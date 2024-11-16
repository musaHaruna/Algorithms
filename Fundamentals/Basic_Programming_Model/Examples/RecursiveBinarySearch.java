public class RecursiveBinarySearch {

    public static int rank(int key, int[] a) {
        // Entry point: Start the binary search with the full array
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        // Base case: If the search range is invalid (lo > hi), key is not present
        if (lo > hi) return -1;

        // Calculate the middle index
        int mid = lo + (hi - lo) / 2; // Avoids overflow compared to (lo + hi) / 2

        // Compare key with the middle element
        if (key < a[mid]) {
            // Key is smaller than the middle element, search the left half
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            // Key is larger than the middle element, search the right half
            return rank(key, a, mid + 1, hi);
        } else {
            // Key matches the middle element, return its index
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11}; // Sorted array
        int key = 7;

        // Perform binary search
        int result = rank(key, a);

        // Output the result
        System.out.println("Index of " + key + ": " + result);
    }
}
