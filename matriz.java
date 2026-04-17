public class MatricesEspeciales {

    // ================== MATRIZ DENSA ==================
    static int[][] crearDensa(int filas, int cols) {
        return new int[filas][cols];
    }

    static void imprimirDensa(int[][] m) {
        for (int[] f : m) {
            for (int v : f) System.out.printf("%4d", v);
            System.out.println();
        }
    }

    static int[][] sumarDensa(int[][] a, int[][] b) {
        int f = a.length, c = a[0].length;
        int[][] res = new int[f][c];
        for (int i = 0; i < f; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = a[i][j] + b[i][j];
        return res;
    }

    // ================== MATRIZ DIAGONAL (almacenada en 1D) ==================
    static int[] crearDiagonal(int n) {
        return new int[n];
    }

    static void imprimirDiagonal(int[] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d", i == j ? d[i] : 0);
            System.out.println();
        }
    }

    // Multiplicación de diagonal (d) por matriz densa (m)
    static int[][] multiplicarDiagonalPorDensa(int[] d, int[][] m) {
        int n = d.length;
        int cols = m[0].length;
        int[][] res = new int[n][cols];
        for (int i = 0; i < n; i++) {
            int diagVal = d[i];
            if (diagVal != 0)
                for (int j = 0; j < cols; j++)
                    res[i][j] = diagVal * m[i][j];
        }
        return res;
    }

    // ================== MATRIZ TRIANGULAR SUPERIOR (almacenada en 1D) ==================
    static int[] crearTriangularSuperior(int n) {
        int size = n * (n + 1) / 2;
        return new int[size];
    }

    static int indice(int i, int j, int n) {
        return i * n + j - i * (i + 1) / 2;
    }

    static void setTriangular(int[] t, int n, int i, int j, int val) {
        if (i <= j) t[indice(i, j, n)] = val;
    }

    static int getTriangular(int[] t, int n, int i, int j) {
        return i <= j ? t[indice(i, j, n)] : 0;
    }

    static void imprimirTriangular(int[] t, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d", getTriangular(t, n, i, j));
            System.out.println();
        }
    }

    // Transposición de triangular superior -> devuelve densa (triangular inferior)
    static int[][] transponerTriangular(int[] t, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int val = getTriangular(t, n, i, j);
                res[j][i] = val;  // traspuesta coloca el valor en (j,i)
            }
        return res;
    }

    // ================== MAIN ==================
    public static void main(String[] args) {
        // 1. MATRIZ DENSA: suma
        System.out.println("=== MATRIZ DENSA: SUMA ===");
        int[][] A = crearDensa(3, 3);
        int[][] B = crearDensa(3, 3);
        int val = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                A[i][j] = val++;
                B[i][j] = (i + j) * 2;
            }
        System.out.println("Matriz A:");
        imprimirDensa(A);
        System.out.println("Matriz B:");
        imprimirDensa(B);
        int[][] suma = sumarDensa(A, B);
        System.out.println("Suma A+B:");
        imprimirDensa(suma);

        // 2. MATRIZ DIAGONAL: multiplicación con matriz densa
        System.out.println("\n=== MATRIZ DIAGONAL: MULTIPLICACIÓN ===");
        int[] diag = crearDiagonal(3);
        diag[0] = 2;
        diag[1] = 0;
        diag[2] = 5;
        System.out.println("Matriz diagonal D:");
        imprimirDiagonal(diag);
        System.out.println("Matriz densa C (la misma A de antes):");
        imprimirDensa(A);
        int[][] prod = multiplicarDiagonalPorDensa(diag, A);
        System.out.println("Producto D * C:");
        imprimirDensa(prod);

        // 3. MATRIZ TRIANGULAR SUPERIOR: transposición
        System.out.println("\n=== MATRIZ TRIANGULAR SUPERIOR: TRANSPOSICIÓN ===");
        int n = 3;
        int[] tri = crearTriangularSuperior(n);
        setTriangular(tri, n, 0, 0, 1);
        setTriangular(tri, n, 0, 1, 2);
        setTriangular(tri, n, 0, 2, 3);
        setTriangular(tri, n, 1, 1, 4);
        setTriangular(tri, n, 1, 2, 5);
        setTriangular(tri, n, 2, 2, 6);
        System.out.println("Matriz triangular superior U:");
        imprimirTriangular(tri, n);
        int[][] transpuesta = transponerTriangular(tri, n);
        System.out.println("Traspuesta de U (triangular inferior):");
        imprimirDensa(transpuesta);
    }
}
