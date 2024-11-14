public class MathFunctions {

    // Compute the absolute value of an integer
    public static int abs(int x) {
        // If x is negative, return its positive counterpart; otherwise, return x as is
        return (x < 0) ? -x : x;
    }

    // Compute the absolute value of a double
    public static double abs(double x) {
        // If x is negative, return its positive counterpart; otherwise, return x as is
        return (x < 0.0) ? -x : x;
    }

    // Check if a number is prime
    public static boolean isPrime(int N) {
        // Return false for numbers less than 2, as they are not prime
        if (N < 2) return false;
        
        // Loop from 2 up to the square root of N
        for (int i = 2; i * i <= N; i++) {
            // If N is divisible by i, it’s not prime
            if (N % i == 0) return false;
        }
        
        // If no divisors were found, return true (N is prime)
        return true;
    }

    // Compute the square root of a number using Newton's method
    public static double sqrt(double c) {
        // Return NaN (Not a Number) if c is negative, as square roots of negatives are undefined for real numbers
        if (c < 0) return Double.NaN;
        
        double err = 1e-15; // Define precision tolerance
        double t = c; // Initialize t with the input value c
        
        // Continue updating t until the error is within the specified tolerance
        while (Math.abs(t - c / t) > err * t) {
            // Update t using Newton’s approximation formula
            t = (c / t + t) / 2.0;
        }
        
        // Return the computed square root
        return t;
    }

    // Compute the hypotenuse of a right triangle given sides a and b
    public static double hypotenuse(double a, double b) {
        // Use the Pythagorean theorem and Math.sqrt to calculate the hypotenuse
        return Math.sqrt(a * a + b * b);
    }

    // Compute the Nth harmonic number
    public static double harmonic(int N) {
        double sum = 0.0; // Initialize sum to accumulate harmonic series
        
        // Sum up 1/i for each i from 1 to N
        for (int i = 1; i <= N; i++) {
            sum += 1.0 / i;
        }
        
        // Return the harmonic sum
        return sum;
    }

    // Main method for testing the functions
    public static void main(String[] args) {
        // Test absolute value functions
        System.out.println("Absolute value of -5 (int): " + abs(-5));
        System.out.println("Absolute value of -3.2 (double): " + abs(-3.2));

        // Test prime number check
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 8 prime? " + isPrime(8));

        // Test square root calculation
        System.out.println("Square root of 25: " + sqrt(25));
        System.out.println("Square root of -4 (should be NaN): " + sqrt(-4));

        // Test hypotenuse calculation
        System.out.println("Hypotenuse of a triangle with sides 3 and 4: " + hypotenuse(3, 4));

        // Test harmonic number calculation
        System.out.println("Harmonic number for N=5: " + harmonic(5));
    }
}
