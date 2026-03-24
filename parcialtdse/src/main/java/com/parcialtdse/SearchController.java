package com.parcialtdse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/busquedaLineal")
    public SearchResult busquedaLineal(
            @RequestParam String lista,
            @RequestParam String valor) {

        String[] elementos = lista.split(",");
        int indice = -1;

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].trim().equals(valor.trim())) {
                indice = i;
                break;
            }
        }

        return new SearchResult("busquedaLineal", lista, valor, String.valueOf(indice));
    }

    @GetMapping("/busquedaBinaria")
    public SearchResult busquedaBinaria(
            @RequestParam String lista,
            @RequestParam String valor) {

        String[] elementos = lista.split(",");
        int resultado = busquedaBinariaRecursiva(elementos, valor.trim(), 0, elementos.length - 1);

        return new SearchResult("busquedaBinaria", lista, valor, String.valueOf(resultado));
    }

    private int busquedaBinariaRecursiva(String[] elementos, String valor, int inf, int sup) {
        if (inf > sup) {
            return -1;
        }

        int mid = (inf + sup) / 2;
        int cmp = elementos[mid].trim().compareTo(valor);

        if (cmp == 0) {
            return mid;
        } else if (cmp > 0) {
            return busquedaBinariaRecursiva(elementos, valor, inf, mid - 1);
        } else {
            return busquedaBinariaRecursiva(elementos, valor, mid + 1, sup);
        }
    }
}