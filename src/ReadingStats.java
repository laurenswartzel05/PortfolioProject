/**
 * Demonstrates analytical usage of the ReadingQueue component.
 *
 * @author Lauren Swartzel
 *
 *         This program shows how the ReadingQueue can be used to check for the
 *         presence of specific books and track the total number of books in the
 *         queue.
 */
public final class ReadingStats {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ReadingStats() {
        //No code needed, just prevents checkstyle errors
    }

    /**
     * Main method demonstrating ReadingQueue analysis features.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        ReadingQueue queue = new ReadingQueue1L();

        queue.addBook("Book A");
        queue.addBook("Book B");

        if (queue.containsBook("Book A")) {
            System.out.println("You plan to read Book A!");
        }

        System.out.println("Total books to read: " + queue.size());
    }
}
