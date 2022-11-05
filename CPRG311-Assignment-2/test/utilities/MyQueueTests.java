/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;

/**
 * @author J.Pointer
 *
 */
class MyQueueTests {
	private MyQueue<String> queue;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		queue = new MyQueue<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	/**
	 * Test method for {@link utilities.MyQueue#MyQueue()}.
	 */
	@Test
	void testMyQueueWithDefaultMaxSize() {
		assertTrue(queue != null);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#MyQueue()}.
	 */
	@Test
	void testMyQueueWithMaxSizePassedThrough() {
		MyQueue<String> testQueue = new MyQueue<>(20);
		assertTrue(testQueue != null);
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueue() {
		queue.enqueue("Abc");

		try {
			assertTrue(queue.peek().equals("Abc"));
		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't throw when peaking after enqueuing");
		}
	}

	void testMultipleEnqueues() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");

		try {
			assertTrue(queue.peek().equals("A"));
		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't throw when peaking after enqueuing");
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueueNullPointerException() {
		try {
			queue.enqueue(null);
			fail("NullPointerException Didn't get thrown when peeking");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	void testDequeue() {
		queue.enqueue("A");

		try {
			String test = queue.dequeue();
			assertTrue(test.equals("A"));
		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't be thrown when dequeueing");
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	void testMultipleDequeues() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");

		try {
			assertTrue(queue.dequeue().equals("A"));
			assertTrue(queue.dequeue().equals("B"));
			assertTrue(queue.dequeue().equals("C"));
			assertTrue(queue.dequeue().equals("D"));
			assertTrue(queue.dequeue().equals("E"));

		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't be thrown when dequeueing");
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	void testDequeueEmptyQueueException() {
		try {
			queue.dequeue();
			fail("EmptyQueueException didn't throw when dequeuing");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	void testPeek() {
		queue.enqueue("Abc");

		try {
			assertTrue(queue.peek().equals("Abc"));
		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't throw when peaking");
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	void testMultiplePeeks() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");

		try {
			assertTrue(queue.peek().equals("A"));
			queue.dequeue();
			assertTrue(queue.peek().equals("B"));
			queue.dequeue();
			assertTrue(queue.peek().equals("C"));
			queue.dequeue();
			assertTrue(queue.peek().equals("D"));
			queue.dequeue();
			assertTrue(queue.peek().equals("E"));
		} catch (EmptyQueueException e) {
			fail("EmptyQueueException shouldn't throw when peaking");
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	void testPeakEmptyQueueException() {
		try {
			queue.peek();
			fail("EmptyQueueException didn't throw");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAll() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");

		queue.dequeueAll();

		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsNotEmpty() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");

		assertFalse(queue.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> queueIter = queue.iterator();
		assertFalse(queueIter.hasNext());
		try {
			queueIter.next();
			fail("NoSuchElementException didn't throw");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		queue.enqueue("Hoang");
		queue.enqueue("Jacque");
		queue.enqueue("Benmarc");
		Iterator<String> stackIter = queue.iterator();
		assertTrue(stackIter.hasNext());
		assertEquals(stackIter.next(), "Hoang");
		assertEquals(stackIter.next(), "Jacque");
		assertEquals(stackIter.next(), "Benmarc");
		assertFalse(stackIter.hasNext());

		try {
			stackIter.next();
			fail("NoSuchElementException didn't throw");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#equals()}.
	 */
	@Test
	void testEquals() {
		MyQueue<String> equalQueue = new MyQueue<>();
		equalQueue.enqueue("A");
		equalQueue.enqueue("B");
		equalQueue.enqueue("C");

		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		assertTrue(queue.equals(equalQueue));
	}

	/**
	 * Test method for {@link utilities.MyStack#equals()}.
	 */
	@Test
	void testNotEquals() {
		MyQueue<String> equalQueue = new MyQueue<>();
		equalQueue.enqueue("A");
		equalQueue.enqueue("B");

		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");

		assertFalse(queue.equals(equalQueue));
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	@Test
	void testToArray() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		Object[] queueToArray = queue.toArray();
		
		assertTrue(queueToArray != null);
		assertTrue(queueToArray.length == 3);
		assertTrue(((String)(queueToArray[0])).equals("A"));
		assertTrue(((String)(queueToArray[2])).equals("C"));
		
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		String[] queueToArray = new String[3]; 
		queue.toArray(queueToArray);
		
		assertTrue(queueToArray != null);
		assertTrue(queueToArray.length == 3);
		assertTrue(queueToArray[0].equals("A"));
		assertTrue(queueToArray[2].equals("C"));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		try {
			queue.toArray(null);
			fail("NullPointerException was not thrown");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
		
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsFull() {
		MyQueue<String> fixedSizedQueue = new MyQueue<>(20);
		for (int i = 0; i < 20; i++) {
			fixedSizedQueue.enqueue(i + "");
		}
		
		assertTrue(fixedSizedQueue.isFull());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsNotFull() {
		MyQueue<String> fixedSizedQueue = new MyQueue<>(20);
		for (int i = 0; i < 5; i++) {
			fixedSizedQueue.enqueue(i + "");
		}
		
		assertFalse(fixedSizedQueue.isFull());
		
		for (int i = 0; i < 200; i++) {
			queue.enqueue(i + "");
		}
		
		assertFalse(queue.isFull());
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeIsGreaterThanZero() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		assertTrue(queue.size() == 3);
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeIsZero() {
		assertTrue(queue.size() == 0);
	}

}
