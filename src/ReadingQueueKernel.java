import components.standard.Standard;

/**
 * Kernel interface for a ReadingQueue component.
 *
 * A ReadingQueue represents a queue of books that a user intends to read. Books
 * are processed in a first-in, first-out order.
 *
 */
public interface ReadingQueueKernel extends Standard<ReadingQueue> {
    /**
     * Adds a book to the end of the reading queue.
     *
     * @param title
     *            the title of the book to add
     * @updates this
     * @requires title is not null
     * @ensures the book is added to the end of the queue
     */
    void addBook(String title);

    /**
     * Removes and returns the next book to be read.
     *
     * @return the next book in the queue
     * @updates this
     * @requires this.size() > 0
     * @ensures the front book is removed and returned
     */
    String removeNextBook();

    /**
     * Returns the number of books in the reading queue.
     *
     * @return the number of books
     * @ensures size = number of books in queue
     */
    int size();
}
