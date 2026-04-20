/**
 * Secondary (enhanced) methods for ReadingQueue.
 * 
 * @author Lauren Swartzel
 */
public abstract class ReadingQueueSecondary implements ReadingQueue {

    /**
     * Reports whether the given title exists in the reading queue.
     *
     * @param title
     *            the book title to search for
     * @return true if the title is in the queue, false otherwise
     * @requires title is not null
     * @ensures containsBook = (title is in this)
     */
    @Override
    public boolean containsBook(String title) {
        boolean found = false;
        int n = this.size();

        for (int i = 0; i < n; i++) {
            String current = this.removeNextBook();

            if (current.equals(title)) {
                found = true;
            }

            this.addBook(current);
        }

        return found;
    }

    /**
     * Moves the specified book to the front of the queue if it exists.
     *
     * @param title
     *            the title of the book to move
     * @updates this
     * @requires title is not null
     * @ensures if title is in this, then it is moved to the front of this;
     *          otherwise, this is unchanged
     */
    @Override
    public void moveToFront(String title) {
        int n = this.size();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            String current = this.removeNextBook();

            if (current.equals(title) && !found) {
                found = true;
            } else {
                this.addBook(current);
            }
        }

        if (found) {
            this.addBook(title);

            for (int i = 0; i < this.size() - 1; i++) {
                this.addBook(this.removeNextBook());
            }
        }
    }

    /**
     * Returns a string representation of the reading queue.
     *
     * @return a string containing all books in order
     * @ensures toString = string representation of this
     */
    @Override
    public String toString() {
        String result = "[";
        int n = this.size();

        for (int i = 0; i < n; i++) {
            String current = this.removeNextBook();
            result += current;

            if (i < n - 1) {
                result += ", ";
            }

            this.addBook(current);
        }

        result += "]";
        return result;
    }

    /**
     * Compares this ReadingQueue to another object for equality.
     *
     * @param obj
     *            the object to compare with
     * @return true if obj is a ReadingQueue with the same contents in the same
     *         order
     * @ensures equals = (obj is a ReadingQueue and has same contents as this)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReadingQueue)) {
            return false;
        }

        ReadingQueue other = (ReadingQueue) obj;

        if (this.size() != other.size()) {
            return false;
        }

        int n = this.size();
        boolean equal = true;

        for (int i = 0; i < n; i++) {
            String thisItem = this.removeNextBook();
            String otherItem = other.removeNextBook();

            if (!thisItem.equals(otherItem)) {
                equal = false;
            }

            this.addBook(thisItem);
            other.addBook(otherItem);
        }

        return equal;
    }
}