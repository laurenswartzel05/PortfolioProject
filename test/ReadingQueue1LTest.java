/**
 * Test cases for the ReadingQueue1L kernel implementation.
 *
 * @author Lauren Swartzel
 */
public class ReadingQueue1LTest {

    /**
     * Tests constructor creates an empty queue.
     */
    @Test
    public void testConstructor() {
        ReadingQueue q = new ReadingQueue1L();
        assertEquals(0, q.size());
    }

    /**
     * Tests adding a single book increases the size to one.
     */
    @Test
    public void testAddBook() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("Book A");
        assertEquals(1, q.size());
    }

    /**
     * Tests adding multiple books updates the size correctly.
     */
    @Test
    public void testAddMultipleBooks() {
        ReadingQueue q = new ReadingQueue1L();
        final int three = 3;
        q.addBook("A");
        q.addBook("B");
        q.addBook("C");
        assertEquals(three, q.size());
    }

    /**
     * Tests removeNextBook removes and returns the front book.
     */
    @Test
    public void testRemoveNextBook() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");

        String removed = q.removeNextBook();

        assertEquals("A", removed);
        assertEquals(1, q.size());
    }

    /**
     * Tests that books are removed in FIFO order.
     */
    @Test
    public void testFIFOOrder() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");
        q.addBook("C");

        assertEquals("A", q.removeNextBook());
        assertEquals("B", q.removeNextBook());
        assertEquals("C", q.removeNextBook());
    }

    /**
     * Tests clear removes all elements from the queue.
     */
    @Test
    public void testClear() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");

        q.clear();

        assertEquals(0, q.size());
    }

    /**
     * Tests newInstance returns an empty queue and does not modify the
     * original.
     */
    @Test
    public void testNewInstance() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");

        ReadingQueue newQ = q.newInstance();

        assertEquals(0, newQ.size());
        assertEquals(1, q.size());
    }

    /**
     * Tests transferFrom moves all elements and clears the source queue.
     */
    @Test
    public void testTransferFrom() {
        ReadingQueue q1 = new ReadingQueue1L();
        ReadingQueue q2 = new ReadingQueue1L();

        q1.addBook("A");
        q1.addBook("B");

        q2.transferFrom(q1);

        assertEquals(2, q2.size());
        assertEquals(0, q1.size());
    }
}
