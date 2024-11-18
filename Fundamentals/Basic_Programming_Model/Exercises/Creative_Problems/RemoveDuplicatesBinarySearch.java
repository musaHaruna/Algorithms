
/**
 * 1.1.28 Remove duplicates.
 * Modify the test client in BinarySearch to remove any duplicate keys in the whitelist after the sort.
 * The array is already sorted.
 */
public class RemoveDuplicatesBinarySearch {

    public static void main(String[] args) {
        int[] allowlist = {1, 3, 3, 5, 7, 7, 9, 11}; // Sorted array with duplicates
        allowlist = removeDuplicates(allowlist); // Remove duplicates

        int key = 7; // The single key to search for

        int lo = 0;
        int hi = allowlist.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < allowlist[mid]) {
                hi = mid - 1;
            } else if (key > allowlist[mid]) {
                lo = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        if (result == -1) {
            System.out.println("Key " + key + " not found.");
        } else {
            System.out.println("Key " + key + " found at index " + result + ".");
        }
    }

    // Method to remove duplicates from a sorted array
    private static int[] removeDuplicates(int[] array) {
        if (array.length == 0) return array;

        int uniqueCount = 1; // At least one unique element exists
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                uniqueCount++;
            }
        }

        int[] uniqueArray = new int[uniqueCount];
        uniqueArray[0] = array[0];
        int index = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                uniqueArray[index++] = array[i];
            }
        }

        return uniqueArray;
    }
}
