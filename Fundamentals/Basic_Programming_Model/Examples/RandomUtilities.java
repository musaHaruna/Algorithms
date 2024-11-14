import java.util.Random;

public class RandomUtilities {
    
    private static final Random random = new Random();

    // Generate a random double value in the range [a, b)
    public static double uniform(double a, double b) {
        // Generate a random double between 0 (inclusive) and 1 (exclusive), scale to [a, b)
        return a + random.nextDouble() * (b - a);
    }

    // Generate a random integer in the range [0, N)
    public static int uniform(int N) {
        // Scale a random double [0, 1) to the range [0, N) and cast to int
        return (int) (random.nextDouble() * N);
    }

    // Generate a random integer in the range [lo, hi)
    public static int uniform(int lo, int hi) {
        // Offset by 'lo' and scale random value to span [lo, hi)
        return lo + uniform(hi - lo);
    }

    // Generate a random integer drawn from a discrete distribution defined by array 'a'
    // 'a' is an array where each element a[i] represents the probability of selecting index i
    public static int discrete(double[] a) {
        // Entries in 'a' must sum to 1
        double r = random.nextDouble();  // Random value between 0.0 and 1.0
        double sum = 0.0;  // Cumulative probability
        
        // Iterate over distribution array
        for (int i = 0; i < a.length; i++) {
            sum += a[i];  // Add probability at index i
            if (sum >= r) {  // If cumulative probability surpasses random value, return i
                return i;
            }
        }
        
        return -1;  // If no index was selected, return -1 (should not occur if a[] sums to 1)
    }

    // Randomly shuffle the elements in an array of double values
    public static void shuffle(double[] a) {
        int N = a.length;  // Get length of the array
        
        // Iterate over each element in array 'a'
        for (int i = 0; i < N; i++) {
            // Select a random index 'r' from i to N-1 (inclusive)
            int r = i + uniform(N - i);
            
            // Swap elements at i and r to shuffle array
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        // Examples for testing

        // Generate a random double in range [5.0, 10.0)
        System.out.println("Random double in [5.0, 10.0): " + uniform(5.0, 10.0));

        // Generate a random integer in range [0, 100)
        System.out.println("Random integer in [0, 100): " + uniform(100));

        // Generate a random integer in range [50, 100)
        System.out.println("Random integer in [50, 100): " + uniform(50, 100));

        // Test discrete random selection with probabilities
        double[] probabilities = {0.2, 0.5, 0.3};  // Sum must be 1
        System.out.println("Discrete random index: " + discrete(probabilities));

        // Test shuffle method
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        shuffle(array);
        System.out.print("Shuffled array: ");
        for (double num : array) {
            System.out.print(num + " ");
        }
    }
}
