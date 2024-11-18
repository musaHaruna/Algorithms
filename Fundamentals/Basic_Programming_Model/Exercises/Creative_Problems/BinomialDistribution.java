public class BinomialDistribution {

    static int count = 0;

    public static void main(String[] args) {
        // Hardcoded input values
        int N = 100; // Number of trials
        int k = 50;  // Number of successes
        double p = 0.25; // Probability of success

        binomial2Start(N, k, p);  // Call the optimized version
    }

    // Naive recursive method
    public static double binomial(int N, int k, double p) {
        count++; // Increment recursive call count
        System.out.println(count);

        if ((N == 0) && (k == 0)) return 1.0; // Base case: 1 way to have 0 successes in 0 trials
        if ((N < 0) || (k < 0)) return 0.0;  // Invalid state

        // Recursive calculation
        return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    // Optimized recursive method with memoization
    public static void binomial2Start(int N, int k, double p) {
        double[][] arr = new double[N + 1][k + 1]; // 2D array for memoization

        // Initialize all entries to -1 (indicating not computed yet)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }

        System.out.println(binomial2(arr, N, k, p));  // Compute and print result
    }

    public static double binomial2(double[][] arr, int N, int k, double p) {
        count++;
        System.out.println(count);

        if ((N == 0) && (k == 0)) return 1.0; // Base case
        if ((N < 0) || (k < 0)) return 0.0;  // Invalid state

        // If value is not yet computed, calculate and store it
        if (arr[N][k] == -1) {
            arr[N][k] = (1 - p) * binomial2(arr, N - 1, k, p) + p * binomial2(arr, N - 1, k - 1, p);
        }

        return arr[N][k]; // Return the stored value
    }
}
