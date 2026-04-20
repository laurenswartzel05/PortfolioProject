/**
 * Demonstrates basic usage of the ReadingQueue component.
 *
 * @author Lauren Swartzel
 *
 *         This program simulates a user maintaining a reading list. It shows
 *         how to add books, view the queue, remove the next book to read, and
 *         reprioritize a book by moving it to the front.
 */
public final class ReadingTracker {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ReadingTracker() {
        //No code needed, just fixes checkstyle
    }

    /**
     * Main method demonstrating ReadingQueue functionality.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        ReadingQueue queue = new ReadingQueue1L();

        queue.addBook("Harry Potter");
        queue.addBook("Atomic Habits");
        queue.addBook("The Hobbit");

        System.out.println("Current Queue: " + queue);

        System.out.println("Next book: " + queue.removeNextBook());

        queue.moveToFront("The Hobbit");

        System.out.println("After reprioritizing: " + queue);
    }
}
