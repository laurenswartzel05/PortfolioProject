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
