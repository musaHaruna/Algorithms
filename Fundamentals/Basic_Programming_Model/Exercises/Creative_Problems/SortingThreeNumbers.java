// Exercise 1.1.26: Sorting three numbers
// Suppose that the variables a, b, c, and t are all of the same numeric primitive type.
// Show that the following code puts a, b, and c in ascending order:

// The purpose of this code is to sort the three variables (a, b, c) in ascending order using conditional swaps.
// We are using a temporary variable t to hold one of the values during the swapping process.

public class SortingThreeNumbers {
    public static void main(String[] args) {
        // Example values for a, b, and c
        int a = 5, b = 2, c = 8, t;

        // First, we compare a and b.
        // If a > b, we swap them so that a becomes the smaller value and b becomes the larger.
        if (a > b) {
            t = a;  // store a in t
            a = b;  // assign b to a
            b = t;  // assign t (which holds a) to b
        }

        // After that, we compare a and c.
        // If a > c, we swap them similarly to the previous step.
        if (a > c) {
            t = a;  // store a in t
            a = c;  // assign c to a
            c = t;  // assign t (which holds a) to c
        }

        // Finally, we compare b and c.
        // If b > c, we swap them to ensure that b is smaller than c.
        if (b > c) {
            t = b;  // store b in t
            b = c;  // assign c to b
            c = t;  // assign t (which holds b) to c
        }

        // After all the comparisons and swaps, the values of a, b, and c are now sorted in ascending order.
        System.out.println("Sorted numbers: " + a + ", " + b + ", " + c);
    }
}
