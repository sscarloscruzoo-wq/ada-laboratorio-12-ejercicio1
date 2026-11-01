package edu.utp.ada.s12.a01;

import java.util.*;

/**
 * Completar los métodos de este ticket; Main ejecuta solamente este ejercicio.
 */
public class Busqueda {

    public static class Resultado {

        public final int indice, comparaciones;

        Resultado(int indice, int comparaciones) {
            this.indice = indice;
            this.comparaciones = comparaciones;
        }
    }

    public static Resultado buscarLineal(List<String> datos, String clave) {
        int comparaciones = 0;

        // TODO 1 & 2: Recorrer cada posición y contar las comparaciones
        for (int i = 0; i < datos.size(); i++) {
            comparaciones++;

            // TODO 3: Retornar el índice cuando se encuentre la clave
            if (datos.get(i).equals(clave)) {
                return new Resultado(i, comparaciones);
            }
        }

        // TODO 4: Si no existe, retornar -1 y el total comparado
        return new Resultado(-1, comparaciones);
    }
}
