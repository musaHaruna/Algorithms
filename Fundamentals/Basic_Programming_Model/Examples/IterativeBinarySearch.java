public class IterativeBinarySearch {

    public static void main(String[] args) {
        int[] allowlist = {1, 3, 5, 7, 9, 11}; // Pre-sorted array
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
}
