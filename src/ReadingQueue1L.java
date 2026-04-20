import java.util.ArrayList;

/**
 * Kernel implementation of ReadingQueue using an ArrayList.
 */

public class ReadingQueue1L extends ReadingQueueSecondary {
    /**
     * Internal representation of the reading queue.
     */
    private ArrayList<String> books;

    /**
     * Constructs an empty ReadingQueue.
     */
    public ReadingQueue1L() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(String title) {
        assert title != null : "Violation of: title is not null";
        this.books.add(title);
    }

    @Override
    public String removeNextBook() {
        assert this.size() > 0 : "Violation of: this.size() > 0";
        return this.books.remove(0);
    }

    @Override
    public int size() {
        return this.books.size();
    }

    @Override
    public void clear() {
        this.books.clear();
    }

    @Override
    public ReadingQueue newInstance() {
        return new ReadingQueue1L();
    }

    @Override
    public void transferFrom(ReadingQueue source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        ReadingQueue1L localSource = (ReadingQueue1L) source;
        this.books = localSource.books;
        localSource.books = new ArrayList<>();
    }
}
