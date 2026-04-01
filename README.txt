package arreglo_completo;
import java.util.Arrays;

public class ArregloCompleto {

    // BÚSQUEDA LINEAL
    public static int busquedaLineal(int[] arreglo, int clave) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    // BÚSQUEDA BINARIA (requiere arreglo ordenado)
    public static int busquedaBinaria(int[] arreglo, int clave) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == clave) {
                return medio;
            } else if (arreglo[medio] < clave) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // 1. DECLARACIÓN DEL ARREGLO DE TAMAÑO FIJO
        int[] arreglo = new int[6];

        // 2. INSERCIÓN DE VALORES (con validación)
        System.out.println("Insertando valores...");
        if (0 >= 0 && 0 < arreglo.length) arreglo[0] = 10;
        if (1 >= 0 && 1 < arreglo.length) arreglo[1] = 20;
        if (2 >= 0 && 2 < arreglo.length) arreglo[2] = 30;
        if (3 >= 0 && 3 < arreglo.length) arreglo[3] = 40;
        if (4 >= 0 && 4 < arreglo.length) arreglo[4] = 50;

        // Mostrar arreglo después de insertar
        System.out.println("Arreglo después de insertar: " + Arrays.toString(arreglo));

        // 3. ACTUALIZACIÓN
        System.out.println("\nActualizando valor en posición 2...");
        if (2 >= 0 && 2 < arreglo.length) arreglo[2] = 99;

        // Mostrar arreglo actualizado
        System.out.println("Arreglo actualizado: " + Arrays.toString(arreglo));

        // 4. ELIMINACIÓN (poner 0 o un valor especial)
        System.out.println("\nEliminando valor en posición 3...");
        if (3 >= 0 && 3 < arreglo.length) arreglo[3] = 0;

        System.out.println("Arreglo después de eliminar: " + Arrays.toString(arreglo));

        // 5. RECORRIDO COMPLETO
        System.out.println("\nRecorriendo el arreglo:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Pos " + i + ": " + arreglo[i]);
        }

        // 6. COPIA DEL ARREGLO
        System.out.println("\nCopiando arreglo...");
        int[] copia = Arrays.copyOf(arreglo, arreglo.length);

        System.out.println("Copia del arreglo: " + Arrays.toString(copia));

        // 7. BÚSQUEDA LINEAL
        System.out.println("\nBuscando 99 (búsqueda lineal)...");
        int posLineal = busquedaLineal(arreglo, 99);
        System.out.println("Resultado búsqueda lineal: posición = " + posLineal);

        // 8. BÚSQUEDA BINARIA (NECESITA ORDENAR PRIMERO)
        System.out.println("\nOrdenando para búsqueda binaria...");
        Arrays.sort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));

        System.out.println("Buscando 50 (búsqueda binaria)...");
        int posBinaria = busquedaBinaria(arreglo, 50);
        System.out.println("Resultado búsqueda binaria: posición = " + posBinaria);
    }
}
