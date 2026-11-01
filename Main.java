package edu.utp.ada.s12.a01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * TICKET A01 - Inventario: producto sin ordenar. PLANTILLA ESTUDIANTE CON TODO
 */
public class Main {

    static List<String> cargar() throws IOException {
        // El recurso viaja DENTRO del proyecto, no depende del directorio de trabajo.
        try (InputStream in = Main.class.getResourceAsStream("inventario.txt")) {
            if (in == null) {
                throw new FileNotFoundException("Falta inventario.txt en el paquete edu.utp.ada.s12.a01");
            }
            List<String> lista = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (!linea.trim().isEmpty()) {
                        lista.add(linea.trim());
                    }
                }
            }
            return lista;
        }
    }

    static boolean ordenado(List<String> datos) {
        for (int i = 1; i < datos.size(); i++) {
            if (datos.get(i - 1).compareTo(datos.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        List<String> datos = cargar();
        if (datos.isEmpty()) {
            System.out.println("Archivo vacío");
            return;
        }
        String clave = datos.get(datos.size() / 2);
        System.out.println("TICKET A01 | Inventario: producto sin ordenar");
        System.out.println("Registros: " + datos.size() + " | Clave: " + clave + " | Ordenados: " + ordenado(datos));

        Busqueda.Resultado r = Busqueda.buscarLineal(datos, clave);
        System.out.println("Índice: " + r.indice + " | Comparaciones: " + r.comparaciones);
        System.out.println(r.indice >= 0 ? "ENCONTRADO" : "NO ENCONTRADO");
    }
}
