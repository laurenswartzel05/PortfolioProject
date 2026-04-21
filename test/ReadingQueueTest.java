import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for secondary methods of the ReadingQueue kernel.
 *
 * @author Lauren Swartzel
 */
public class ReadingQueueTest {

    /**
     * Tests containsBook returns true when the book is in the queue.
     */
    @Test
    public void testContainsBookTrue() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");

        assertTrue(q.containsBook("A"));
    }

    /**
     * Tests containsBook returns false when the book is not in the queue.
     */
    @Test
    public void testContainsBookFalse() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");

        assertFalse(q.containsBook("Z"));
    }

    /**
     * Tests containsBook does not modify the queue.
     */
    @Test
    public void testContainsBookPreservesQueue() {
        ReadingQueue q = new ReadingQueue1L();
        ReadingQueue copy = new ReadingQueue1L();

        q.addBook("A");
        q.addBook("B");

        copy.addBook("A");
        copy.addBook("B");

        q.containsBook("A");

        assertEquals(copy, q);
    }

    /**
     * Tests moveToFront moves the specified book to the front of the queue.
     */
    @Test
    public void testMoveToFront() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");
        q.addBook("C");

        q.moveToFront("B");

        assertEquals("B", q.removeNextBook());
    }

    /**
     * Tests moveToFront does not modify the queue if the book is not present.
     */
    @Test
    public void testMoveToFrontNotPresent() {
        ReadingQueue q = new ReadingQueue1L();
        ReadingQueue copy = new ReadingQueue1L();

        q.addBook("A");
        q.addBook("B");

        copy.addBook("A");
        copy.addBook("B");

        q.moveToFront("Z");

        assertEquals(copy, q);
    }

    /**
     * Tests toString returns the correct string representation of the queue.
     */
    @Test
    public void testToString() {
        ReadingQueue q = new ReadingQueue1L();
        q.addBook("A");
        q.addBook("B");

        String s = q.toString();

        assertEquals("[A, B]", s);
    }

    /**
     * Tests equals returns true for two queues with the same contents in the
     * same order.
     */
    @Test
    public void testEqualsTrue() {
        ReadingQueue q1 = new ReadingQueue1L();
        ReadingQueue q2 = new ReadingQueue1L();

        q1.addBook("A");
        q2.addBook("A");

        assertTrue(q1.equals(q2));
    }

    /**
     * Tests equals returns false for queues with the same elements in different
     * order.
     */
    @Test
    public void testEqualsFalseDifferentOrder() {
        ReadingQueue q1 = new ReadingQueue1L();
        ReadingQueue q2 = new ReadingQueue1L();

        q1.addBook("A");
        q1.addBook("B");

        q2.addBook("B");
        q2.addBook("A");

        assertFalse(q1.equals(q2));
    }

    /**
     * Tests equals does not modify the state of the queue.
     */
    @Test
    public void testEqualsPreservesState() {
        ReadingQueue q1 = new ReadingQueue1L();
        ReadingQueue q2 = new ReadingQueue1L();

        q1.addBook("A");
        q2.addBook("A");

        ReadingQueue copy = new ReadingQueue1L();
        copy.addBook("A");

        q1.equals(q2);

        assertEquals(copy, q1);
    }
}
