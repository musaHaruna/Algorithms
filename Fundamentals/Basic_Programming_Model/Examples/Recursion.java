public class Recursion {

    // 1. Factorial Calculation (Simple Recursion)
    // Problem: Calculate the factorial of a number n.
    public static int factorial(int n) {
        // Base case: if n is 1, return 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: n * factorial(n - 1)
        return n * factorial(n - 1);
    }

    // 2. Fibonacci Sequence (Recursive Computation)
    // Problem: Compute the nth Fibonacci number.
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        // Recursive case: F(n) = F(n - 1) + F(n - 2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 3. Sum of an Array (Recursive Traversal)
    // Problem: Calculate the sum of an array of integers.
    public static int sum(int[] array, int n) {
        // Base case: if the array size is 0, return 0
        if (n == 0) return 0;
        // Recursive case: add the nth element to the sum of the first n-1 elements
        return array[n - 1] + sum(array, n - 1);
    }

    // 4. Binary Search (Recursive)
    // Problem: Search for a target value in a sorted array using binary search.
    public static int binarySearch(int[] array, int target, int left, int right) {
        // Base case: if left index exceeds right, target is not found
        if (left > right) return -1;

        // Calculate mid-point
        int mid = left + (right - left) / 2;

        // Check if target is at mid
        if (array[mid] == target) return mid;
        // Recursive case: search in left half
        else if (array[mid] > target) return binarySearch(array, target, left, mid - 1);
        // Recursive case: search in right half
        else return binarySearch(array, target, mid + 1, right);
    }

    // 5. Towers of Hanoi (Complex Recursive Problem)
    // Problem: Move a stack of disks from one peg to another following specific rules.
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: if there’s only one disk, move it directly
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        // Recursive case: move top n-1 disks from source to auxiliary
        solveHanoi(n - 1, source, destination, auxiliary);
        // Move nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        // Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    // Main method to demonstrate each recursive example
    public static void main(String[] args) {
        // 1. Factorial Example
        System.out.println("Factorial of 5 is: " + factorial(5)); // Output: 120

        // 2. Fibonacci Example
        System.out.println("Fibonacci of 6 is: " + fibonacci(6)); // Output: 8

        // 3. Array Sum Example
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Sum of array elements: " + sum(array, array.length)); // Output: 15

        // 4. Binary Search Example
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        int target = 7;
        System.out.println("Index of target: " + binarySearch(sortedArray, target, 0, sortedArray.length - 1)); // Output: 3

        // 5. Towers of Hanoi Example
        int numDisks = 3;
        System.out.println("Solving Towers of Hanoi for " + numDisks + " disks:");
        solveHanoi(numDisks, 'A', 'B', 'C');
    }
}
