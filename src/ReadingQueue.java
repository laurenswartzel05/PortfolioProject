
import java.util.ArrayList;

/**
 * The ReadingQueue class models a personal reading list.
 *
 * Books are stored in a queue-like structure where users can add books, remove
 * the next book to read, and reorder books based on priority.
 */
public class ReadingQueue {

    /**
     * Internal representation of the reading queue.
     */
    private ArrayList<String> books;

    /**
     * Constructs an empty ReadingQueue.
     */
    public ReadingQueue() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the end of the reading queue.
     *
     * @param title
     *            the title of the book to add
     */
    public void addBook(String title) {
        this.books.add(title);
    }

    /**
     * Removes and returns the next book to be read.
     *
     * @return the next book in the queue, or null if the queue is empty
     */
    public String removeNextBook() {
        if (this.books.isEmpty()) {
            return null;
        }
        return this.books.remove(0);
    }

    /**
     * Moves the specified book to the front of the queue if it exists in the
     * reading list.
     *
     * @param title
     *            the title of the book to prioritize
     */
    public void moveToFront(String title) {
        if (this.books.contains(title)) {
            this.books.remove(title);
            this.books.add(0, title);
        }
    }

    /**
     * Determines whether a given book exists in the queue.
     *
     * @param title
     *            the title to search for
     * @return true if the book exists in the queue, false otherwise
     */
    public boolean containsBook(String title) {
        return this.books.contains(title);
    }

    /**
     * Returns the number of books currently in the queue.
     *
     * @return the size of the reading queue
     */
    public int size() {
        return this.books.size();
    }

    /**
     * Demonstrates the functionality of the ReadingQueue class.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {

        ReadingQueue rq = new ReadingQueue();

        rq.addBook("Fourth Wing");
        rq.addBook("The Silent Patient");
        rq.addBook("Atomic Habits");

        System.out.println("Current queue size: " + rq.size());

        rq.moveToFront("Atomic Habits");

        System.out.println("Next book to read: " + rq.removeNextBook());

        System.out.println(
                "Contains Fourth Wing? " + rq.containsBook("Fourth Wing"));

        System.out.println("Remaining books: " + rq.size());
    }

/**
 * Enhanced interface for a ReadingQueue component.
 *
 * This interface extends the kernel and provides additional methods that make
 * the component more useful to clients.
 */
public interface ReadingQueue extends ReadingQueueKernel {

    /**
     * Checks whether the queue contains a specific book.
     *
     * @param title
     *            the book title to search for
     * @return true if the book exists in the queue
     * @ensures containsBook = (title is in queue)
     */
    boolean containsBook(String title);

    /**
     * Moves a book to the front of the queue if it exists.
     *
     * @param title
     *            the title of the book to prioritize
     * @updates this
     * @requires title is not null
     * @ensures if title was in queue it is moved to the front
     */
    void moveToFront(String title);
}
