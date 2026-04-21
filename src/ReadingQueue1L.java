import java.util.ArrayList;

/**
 * Kernel implementation of ReadingQueue using an ArrayList.
 *
 * This implementation represents the reading queue as a list of book titles,
 * where the front of the list (index 0) is the next book to be read.
 *
 * @author Lauren Swartzel
 */
public final class ReadingQueue1L extends ReadingQueueSecondary {

    /**
     * Internal representation of the reading queue.
     */
    private ArrayList<String> books;

    /**
     * Constructs an empty ReadingQueue.
     *
     * @ensures this is empty
     */
    public ReadingQueue1L() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the end of the reading queue.
     *
     * @param title
     *            the title of the book to add
     * @updates this
     * @requires title is not null
     * @ensures this = #this with title added to the end
     */
    @Override
    public void addBook(String title) {
        assert title != null : "Violation of: title is not null";
        this.books.add(title);
    }

    /**
     * Removes and returns the next book to be read.
     *
     * @return the next book in the queue
     * @updates this
     * @requires this.size() > 0
     * @ensures removeNextBook = front of #this and this = #this without its
     *          front element
     */
    @Override
    public String removeNextBook() {
        assert this.size() > 0 : "Violation of: this.size() > 0";
        return this.books.remove(0);
    }

    /**
     * Returns the number of books in the reading queue.
     *
     * @return the number of books
     * @ensures size = |this|
     */
    @Override
    public int size() {
        return this.books.size();
    }

    /**
     * Clears all books from the reading queue.
     *
     * @updates this
     * @ensures this is empty
     */
    @Override
    public void clear() {
        this.books.clear();
    }

    /**
     * Returns a new, empty instance of ReadingQueue.
     *
     * @return a new empty ReadingQueue
     * @ensures newInstance is empty
     */
    @Override
    public ReadingQueue newInstance() {
        return new ReadingQueue1L();
    }

    /**
     * Replaces the contents of this with those of the given source, leaving the
     * source empty.
     *
     * @param source
     *            the ReadingQueue to transfer from
     * @updates this, source
     * @requires source is not null and source is not this
     * @ensures this = #source and source is empty
     */
    @Override
    public void transferFrom(ReadingQueue source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        ReadingQueue1L localSource = (ReadingQueue1L) source;
        this.books = localSource.books;
        localSource.books = new ArrayList<>();
    }
}
