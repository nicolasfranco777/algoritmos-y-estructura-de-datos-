package javaapplication15;
import java.util.Arrays;
public class JavaApplication15 {
    public static int busqueda(int [] arreglo, int clave) {
        for (int i = 0; i<arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i;
            }
        }               
        return -1;
    }
    public static int busquedabinaria(int[] arreglo, int clave) {
        int inicio = 0;
        int fin = arreglo.length -1;
        while (inicio <= fin) {
            int medio = (inicio+fin) / 2;
            if (arreglo[medio]== clave){
                return medio;
                } else 
                if (arreglo[medio] < clave) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
        }
            return -1;
        }
    public static void main(String[] args) {
        int [] datos = {30, 7 , -5, 0, 2, 21};
        int pos1 = busqueda(datos, 30);
        System.out.println("30 esta en la posicion " + pos1);
        Arrays.sort(datos);
        System.out.println("ordenado; " + Arrays.toString(datos));
        int pos2 = busquedabinaria(datos, 21);
        System.out.println("21 esta en la posicion " + pos2);
    }        
    }
