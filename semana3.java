package javaapplication7;
import java.util.Arrays;
public class JavaApplication7 {    
    public static void main(String[] args) {
        System.out.println("=== OPERACIONES CON ARREGLOS EN JAVA ===\n");        
        // 1. Declarar dos arreglos con datos para comparación
        int[] arreglo1 = {15, 23, 42, 7, 89, 34, 56};
        int[] arreglo2 = {15, 23, 42, 7, 89, 34, 56};  // Igual al primero
        // int[] arreglo2 = {15, 23, 50, 7, 90, 34, 56};  // Diferente (para prueba)        
        System.out.println("Arreglo 1: " + Arrays.toString(arreglo1));
        System.out.println("Arreglo 2: " + Arrays.toString(arreglo2));       
        // 2. Implementar algoritmo de comparación elemento por elemento
        System.out.println("\n--- COMPARACIÓN ELEMENTO POR ELEMENTO ---");
        boolean sonIguales = compararArreglos(arreglo1, arreglo2);
        System.out.println("¿Los arreglos son iguales? " + sonIguales);        
        // 3. Crear clonación del arreglo original
        System.out.println("\n--- CLONACIÓN DEL ARREGLO ORIGINAL ---");
        int[] arregloClonado = clonarArreglo(arreglo1);
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Arreglo clonado:  " + Arrays.toString(arregloClonado));        
        // Verificar que son independientes
        arregloClonado[0] = 999;
        System.out.println("Después de modificar el clon:");
        System.out.println("Arreglo original: " + Arrays.toString(arreglo1));
        System.out.println("Arreglo clonado:  " + Arrays.toString(arregloClonado));        
        // 4. Fusionar ambos arreglos en uno nuevo
        System.out.println("\n--- FUSIÓN DE ARREGLOS ---");
        int[] arregloFusionado = fusionarArreglos(arreglo1, arreglo2);
        System.out.println("Arreglo fusionado: " + Arrays.toString(arregloFusionado));
        System.out.println("Tamaño del arreglo fusionado: " + arregloFusionado.length);        
        // 5. Verificar resultados de cada operación
        System.out.println("\n=== VERIFICACIÓN DE RESULTADOS ===");
        verificarResultados(arreglo1, arreglo2, arregloClonado, arregloFusionado, sonIguales);
    }    
    /**
     * 2. Compara dos arreglos elemento por elemento
     * Pauta de seguridad: Verifica límites de los arreglos antes de acceder
     */
    public static boolean compararArreglos(int[] arr1, int[] arr2) {
        // Verificar que ambos arreglos no sean null
        if (arr1 == null || arr2 == null) {
            System.err.println("Error: Uno de los arreglos es null");
            return false;
        }        
        // Verificar que tengan la misma longitud
        if (arr1.length != arr2.length) {
            System.out.println("Los arreglos tienen diferente longitud: " + 
                             arr1.length + " vs " + arr2.length);
            return false;
        }        
        // Comparación elemento por elemento con verificación de límites
        for (int i = 0; i < arr1.length; i++) {
            // Verificación explícita de límites (aunque el for ya lo garantiza)
            if (i >= arr1.length || i >= arr2.length) {
                System.err.println("Error: Índice fuera de límites en posición " + i);
                return false;
            }            
            if (arr1[i] != arr2[i]) {
                System.out.println("Diferencia encontrada en posición " + i + 
                                 ": " + arr1[i] + " vs " + arr2[i]);
                return false;
            }
        }        
        System.out.println("Todos los elementos coinciden en las " + arr1.length + " posiciones");
        return true;
    }    
    /**
     * 3. Clona el arreglo original creando una copia independiente
     */
    public static int[] clonarArreglo(int[] arregloOriginal) {
        if (arregloOriginal == null) {
            System.err.println("Error: No se puede clonar un arreglo null");
            return new int[0];
        }        
        // Método 1: Usando Arrays.copyOf()
        // return Arrays.copyOf(arregloOriginal, arregloOriginal.length);        
        // Método 2: Implementación manual
        int[] clon = new int[arregloOriginal.length];
        for (int i = 0; i < arregloOriginal.length; i++) {
            clon[i] = arregloOriginal[i];
        }
        return clon;
    }    
    /**
     * 4. Fusiona dos arreglos en uno nuevo
     * Pauta de seguridad: Valida tamaño de memoria para fusión
     */
    public static int[] fusionarArreglos(int[] arr1, int[] arr2) {
        // Verificar que los arreglos no sean null
        if (arr1 == null || arr2 == null) {
            System.err.println("Error: No se pueden fusionar arreglos null");
            return new int[0];
        }        
        // Validar tamaño de memoria para fusión
        long nuevoTamaño = (long) arr1.length + (long) arr2.length;        
        // Verificar desbordamiento de memoria (para arreglos muy grandes)
        if (nuevoTamaño > Integer.MAX_VALUE) {
            System.err.println("Error: El tamaño fusionado excede la capacidad máxima del arreglo");
            System.err.println("Tamaño solicitado: " + nuevoTamaño + 
                             " (Máximo: " + Integer.MAX_VALUE + ")");
            return new int[0];
        }       
        // Verificar que haya memoria disponible (simulación)
        try {
            // Intentar estimar memoria necesaria (cada int son 4 bytes aprox)
            long memoriaNecesaria = nuevoTamaño * 4;
            long memoriaMaxima = Runtime.getRuntime().maxMemory();
            long memoriaUsada = Runtime.getRuntime().totalMemory() - 
                               Runtime.getRuntime().freeMemory();            
            if (memoriaNecesaria > (memoriaMaxima - memoriaUsada)) {
                System.err.println("Advertencia: Memoria insuficiente para la fusión");
                System.err.println("Memoria necesaria: " + memoriaNecesaria + " bytes");
                System.err.println("Memoria disponible: " + (memoriaMaxima - memoriaUsada) + " bytes");
                // Continuamos de todas formas, Java lanzará OutOfMemoryError si es necesario
            }
        } catch (Exception e) {
            System.err.println("Error al verificar memoria: " + e.getMessage());
        }        
        // Realizar la fusión
        int[] resultado = new int[(int) nuevoTamaño];        
        // Copiar primer arreglo con verificación de límites
        for (int i = 0; i < arr1.length; i++) {
            if (i >= resultado.length) {
                System.err.println("Error: Índice fuera de límites en copia del primer arreglo");
                return new int[0];
            }
            resultado[i] = arr1[i];
        }       
        // Copiar segundo arreglo con verificación de límites
        for (int i = 0; i < arr2.length; i++) {
            int posDestino = arr1.length + i;
            if (posDestino >= resultado.length) {
                System.err.println("Error: Índice fuera de límites en copia del segundo arreglo");
                return new int[0];
            }
            resultado[posDestino] = arr2[i];
        }       
        return resultado;
    }    
    /**
     * 5. Verifica resultados de cada operación
     */
    public static void verificarResultados(int[] original, int[] segundo, 
                                          int[] clon, int[] fusion, boolean iguales) {
        System.out.println("\n--- VERIFICACIONES ---");        
        // Verificar comparación
        System.out.println("✓ Comparación: " + (iguales ? "Los arreglos son iguales" : "Los arreglos son diferentes"));        
        // Verificar clonación
        boolean clonCorrecto = (original.length == clon.length);
        if (clonCorrecto) {
            for (int i = 0; i < original.length && i < clon.length; i++) {
                if (original[i] != clon[i]) {
                    clonCorrecto = false;
                    break;
                }
            }
        }
        System.out.println("✓ Clonación: " + (clonCorrecto ? "Clon creado correctamente" : "Error en la clonación"));        
        // Verificar fusión
        int tamanioEsperado = original.length + segundo.length;
        boolean fusionCorrecta = (fusion.length == tamanioEsperado);
        
        if (fusionCorrecta) {
            // Verificar contenido del primer arreglo en la fusión
            for (int i = 0; i < original.length && i < fusion.length; i++) {
                if (original[i] != fusion[i]) {
                    fusionCorrecta = false;
                    break;
                }
            }            
            // Verificar contenido del segundo arreglo en la fusión
            if (fusionCorrecta) {
                for (int i = 0; i < segundo.length; i++) {
                    int pos = original.length + i;
                    if (pos < fusion.length && segundo[i] != fusion[pos]) {
                        fusionCorrecta = false;
                        break;
                    }
                }
            }
        }        
        System.out.println("✓ Fusión: " + (fusionCorrecta ? 
                          "Fusión exitosa, tamaño: " + fusion.length : 
                          "Error en la fusión"));       
        // Información de memoria
        System.out.println("\n--- INFORMACIÓN DE MEMORIA ---");
        System.out.println("Arreglo original: " + original.length + " elementos");
        System.out.println("Arreglo clon: " + clon.length + " elementos");
        System.out.println("Arreglo fusionado: " + fusion.length + " elementos");
        System.out.println("Memoria total (estimada): ~" + 
                         ((original.length + clon.length + fusion.length + segundo.length) * 4) + " bytes");
    }
}
