package javaapplication7;
import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaApplication7 {
    
    public static void main(String[] args) {
        // 1. Declaración
        int[] a1 = {15, 23, 42, 7, 89, 34, 56};
        int[] a2 = {15, 23, 42, 7, 89, 34, 56};
        
        // 2. Comparación - UNA línea
        boolean iguales = Arrays.equals(a1, a2);
        
        // 3. Clonación - UNA línea
        int[] clon = Arrays.copyOf(a1, a1.length);
        
        // 4. Fusión - UNA línea (Java 16+)
        int[] fusion = IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).toArray();
        
        // 5. Verificación - usando métodos de Arrays
        System.out.println("=== RESULTADOS ===");
        System.out.println("1. Comparación: " + iguales);
        System.out.println("2. Clonación: " + Arrays.toString(clon));
        System.out.println("3. Fusión: " + Arrays.toString(fusion));
        System.out.println("4. Verificación clon: " + Arrays.equals(a1, clon));
        System.out.println("5. Verificación fusión: " + (fusion.length == a1.length + a2.length));
        
        // Demostrar independencia del clon
        clon[0] = 999;
        System.out.println("\nModificado clon[0]=999:");
        System.out.println("Original: " + Arrays.toString(a1));
        System.out.println("Clon: " + Arrays.toString(clon));
        System.out.println("Son independientes: " + !Arrays.equals(a1, clon));
    }
}
    
