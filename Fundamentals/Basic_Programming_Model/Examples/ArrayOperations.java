public class ArrayOperations {

    // Function to find the maximum value in an array
    public static double findMax(double[] a) {
        // Initialize max with the first element
        double max = a[0];
        // Loop through the array starting from the second element
        for (int i = 1; i < a.length; i++) {
            // Update max if the current element is larger
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    // Function to compute the average of array values
    public static double computeAverage(double[] a) {
        int N = a.length; // Get the length of the array
        double sum = 0.0; // Initialize sum to accumulate array values
        for (int i = 0; i < N; i++) {
            sum += a[i]; // Add each element to the sum
        }
        return sum / N; // Divide by number of elements to get the average
    }

    // Function to copy an array into a new array
    public static double[] copyArray(double[] a) {
        int N = a.length; // Get the length of the array
        double[] b = new double[N]; // Create a new array of the same length
        for (int i = 0; i < N; i++) {
            b[i] = a[i]; // Copy each element from a to b
        }
        return b;
    }

    // Function to reverse the elements within an array
    public static void reverseArray(double[] a) {
        int N = a.length; // Get the length of the array
        // Loop until the midpoint of the array
        for (int i = 0; i < N / 2; i++) {
            // Swap the i-th element with the (N-i-1)-th element
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }
    }

    // Function to perform matrix-matrix multiplication (for square matrices)
    public static double[][] matrixMultiply(double[][] a, double[][] b) {
        int N = a.length; // Get the dimension of the square matrices
        double[][] c = new double[N][N]; // Initialize result matrix

        // Loop through each row of matrix a
        for (int i = 0; i < N; i++) {
            // Loop through each column of matrix b
            for (int j = 0; j < N; j++) {
                // Compute the dot product of row i in a and column j in b
                for (int k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c; // Return the resulting matrix
    }

    // Main method to test the functions
    public static void main(String[] args) {
        // Example array
        double[] a = {1.0, 2.5, 3.2, 4.8, 0.9};

        // Find the maximum value
        System.out.println("Max value: " + findMax(a));

        // Compute the average
        System.out.println("Average: " + computeAverage(a));

        // Copy the array
        double[] b = copyArray(a);
        System.out.println("Copied array: " + java.util.Arrays.toString(b));

        // Reverse the array
        reverseArray(a);
        System.out.println("Reversed array: " + java.util.Arrays.toString(a));

        // Matrix multiplication example
        double[][] matrixA = { {1, 2}, {3, 4} };
        double[][] matrixB = { {5, 6}, {7, 8} };
        double[][] resultMatrix = matrixMultiply(matrixA, matrixB);

        System.out.println("Matrix multiplication result:");
        for (double[] row : resultMatrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
