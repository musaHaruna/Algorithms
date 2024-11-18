public class Knuth {

    public static void main(String[] args) {
        // Define a deck of cards as an array of strings
        String[] a = {
            "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC",
            "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD",
            "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH",
            "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS"
        };

        // Shuffle the deck using the Knuth shuffle algorithm
        int n = a.length; // Get the number of cards in the deck
        for (int i = 0; i < n; i++) {
            // Pick a random index between 0 and i (inclusive)
            int r = (int) (Math.random() * (i + 1));
            // Swap the current card with the randomly chosen card
            String swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }

        // Print the shuffled cards
        for (String s : a) {
            System.out.println(s); // Display each card in a random order
        }
    }
}
