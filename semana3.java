package javaapplication7;
public class JavaApplication7 {
    public static void main(String[] args) {
        int[] a1 = {15, 23, 50, 7, 90, 34, 56};
        int[] a2 = {15, 23, 50, 7, 90, 34, 56};
        
        // Mostrar arreglos manualmente
        System.out.print("A1: [");
        for (int i = 0; i < a1.length; i++) System.out.print(a1[i] + (i < a1.length-1 ? ", " : ""));
        System.out.println("]");
        
        System.out.print("A2: [");
        for (int i = 0; i < a2.length; i++) System.out.print(a2[i] + (i < a2.length-1 ? ", " : ""));
        System.out.println("]");
        
        // 2. Comparación detallada
        System.out.println("\n--- COMPARACIoN ---");
        boolean iguales = true;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                System.out.println("  [" + i + "]: " + a1[i] + " vs " + a2[i] + " (dif: " + Math.abs(a1[i]-a2[i]) + ")");
                iguales = false;
            }
        }
        System.out.println(iguales ? " IDENTICOS" : " DIFERENTES");
        
        // 3. Clonación
        int[] clon = new int[a1.length];
        for (int i = 0; i < a1.length; i++) clon[i] = a1[i];
        
        // Mostrar clon
        System.out.print("\nClon: [");
        for (int i = 0; i < clon.length; i++) System.out.print(clon[i] + (i < clon.length-1 ? ", " : ""));
        System.out.println("]");
        
        // 4. Fusión
        int[] fusion = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) fusion[i] = a1[i];
        for (int i = 0; i < a2.length; i++) fusion[a1.length + i] = a2[i];
        
        // Mostrar fusión
        System.out.print("Fusión: [");
        for (int i = 0; i < fusion.length; i++) System.out.print(fusion[i] + (i < fusion.length-1 ? ", " : ""));
        System.out.println("]");
        
    
    }
}
