package com.parcialtdse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private String getService1() {
        String url = System.getenv("SERVICE1_URL");
        return (url != null) ? url : "http://localhost:8080";
    }

    private String getService2() {
        String url = System.getenv("SERVICE2_URL");
        return (url != null) ? url : "http://localhost:8080";
    }

    @GetMapping("/proxy/busquedaLineal")
    public String proxybusquedaLineal(
            @RequestParam String lista,
            @RequestParam String valor) {

        String endpoint = "/busquedaLineal?list=" + lista + "&value=" + valor;

        try {
            return callService(getService1() + endpoint);
        } catch (Exception e1) {
            System.out.println("Instancia 1 caida, intentando instancia 2...");
            try {
                return callService(getService2() + endpoint);
            } catch (Exception e2) {
                return "{\"error\": \"Ambas instancias no disponibles\"}";
            }
        }
    }

    @GetMapping("/proxy/busquedaBinaria")
    public String proxybusquedaBinaria(
            @RequestParam String lista,
            @RequestParam String valor) {

        String endpoint = "/busquedaBinaria?list=" + lista + "&value=" + valor;

        try {
            return callService(getService1() + endpoint);
        } catch (Exception e1) {
            System.out.println("Instancia 1 caida, intentando instancia 2...");
            try {
                return callService(getService2() + endpoint);
            } catch (Exception e2) {
                return "{\"error\": \"Ambas instancias no disponibles\"}";
            }
        }
    }

    private String callService(String targetUrl) throws Exception {
        URL obj = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Servicio respondio con codigo: " + responseCode);
        }
    }
}