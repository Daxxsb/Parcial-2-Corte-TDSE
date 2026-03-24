# Parcial TDSE Segundo Corte
David Eduardo Salamanca Aguilar - Escuela Colombiana de Ingeniería Julio Garavito - 2026-1

## Análisis

Después de entender el enunciado, empece con el scalffolding de la aplicación principal, esta llamada parcialtdse, se enfocara en la gestión e implementación de las funciones matemáticas solicitadas:

- Búsqueda Lineal
- Búsqueda Binaria

Una vez entendido el contexto, renombre la clase correspondiente a Main para que fuera consistente con el nombre de la aplicación, después plantee dos controladores, uno para manejar los parametros de las funciones matemáticas y otro para integrar las requests Proxys. Los archivos correspondientes son:

- SearchController.java
- ProxyController.java

Seguido, cree el record encargado para los resultados de búsqueda:

- SearchResult.java

## Resultados

1. Lo primero validar la construcción y ejecución de la aplicación

    ![alt text](img/1.png)

2. Ahora entramos desde el navegador

    ![alt text](img/2.png)

3. Validamos PROXY

    ![alt text](img/3.png)

    Resultado esperado pues para este paso no hemos iniciado instancias

4. Validamos por URL

    ![alt text](img/4.png)
    ![alt text](img/5.png)
    En las imagenes se evidencia el resultado esperado para los parametros indicados, en el formato comentado en el enunciado.

## Configuración y Despliegue

1. Entramos AWS EC2 al apartado de instancias
    ![alt text](img/6.png)

2. La idea principal es crear dos instancias para los servicios matemáticos y una para PROXY, esto de acuerdo a la arquitectura sugerida
    ![alt text](img/7.png)
    Debemos crear un grupo de reglas de seguridad en donde habilitamos la conexión HTTP, con los parametros indicados en la imagen
    ![alt text](img/8.png)
    Lanzamos la instancia
    ![alt text](img/9.png)
    Ahora nos conectamos por ssh y empezamos con la configuración de la instancia
    ![alt text](img/10.png)
    Actualizamos e instalamos la versión trabajada de Java
    ![alt text](img/11.png)
    ![alt text](img/12.png)
    Hacemos lo mismo con la otra instancia
    ![alt text](img/13.png)
    Después cargamos el .jar en ambas instancias
    ![alt text](img/14.png)
    Hacemos exactamente lo mismo con la tercera destinada al PROXY
    ![alt text](img/15.png)

3. Validamos que las tres instancias esten corriendo
    ![alt text](img/16.png)