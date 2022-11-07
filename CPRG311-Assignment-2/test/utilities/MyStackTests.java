/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The Class MyStackTests.
 *
 */
class MyStackTests {

	/** The stack. */
	StackADT<String> stack;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		stack.push("Hoang");
		stack.push("Benmarc");
		if (stack.pop() == "Benmarc") {
			assertTrue(true);
		} else {
			fail();
		}
		if (stack.pop() == "Hoang") {
			assertTrue(true);
		} else {
			fail();
		}
		
	}
	
	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNullPointerException() {
		try {
			stack.push(null);
			fail("Didn't throw NullPointerExxception");
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
		
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		stack.push("Jacque");
		stack.push("Evan");
		if (stack.pop() == "Evan") {
			assertTrue(true);
		} else {
			fail();
		}
		if (stack.pop() == "Jacque") {
			assertTrue(true);
		} else {
			fail();
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopEmptyStackException() {
		try {
			stack.pop();
			fail("Didn't throw EmptyStackException");
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		stack.push("Linear straw");
		stack.push("Locause");
		if (stack.peek() == "Locause") {
			assertTrue(true);
		} else {
			fail("Peek is failed");
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekEmptyStackException() {
		try {
			stack.peek();
			fail("Didn't throw EmptyStackException");
		} catch(EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Evan");
		stack.push("Benmarc");
		stack.clear();
		
		assertTrue(stack.isEmpty());
		assertFalse(stack.size() != 0);
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isNotEmpty()}.
	 */
	@Test
	void testIsNotEmpty() {
		stack.push("String");
		assertFalse(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Evan");
		stack.push("Benmarc");
		
		Object[] objectArray = stack.toArray();
		
		assertTrue(objectArray != null);
		assertTrue(objectArray[0].equals("Hoang"));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArrayEmptyStackException() {
		stack.push("Hoang");
		stack.push("Benmarc");
		stack.pop();
		stack.pop();
		try {
			stack.toArray();
			fail("Didn't throw EmptyStackException");
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Evan");
		stack.push("Benmarc");
		
		String[] array = new String[stack.size()];	
		array = stack.toArray(array);
		
		assertTrue(array != null);
		assertTrue(array[0].equals("Hoang"));
		
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNull() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Evan");
		stack.push("Benmarc");
		
		try {
			String[] array = null;	
			array = stack.toArray(array);
			fail("NullPointerException didn't throw");
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayEmpty() {
		try {
			String[] array = new String[stack.size()];	
			array = stack.toArray(array);
			fail("NullPointerException didn't throw");
		} catch (EmptyStackException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		stack.push("Hoang");
		stack.push("Jacque");
		
		assertTrue(stack.contains("Hoang"));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testNotContains() {
		stack.push("Hoang");
		stack.push("Evan");
		
		assertFalse(stack.contains("Jacque"));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNull() {
		stack.push("Hoang");
		stack.push("Evan");
		try {
			stack.contains(null);
			fail("Didn't throw NullPointerException");
		} catch(NullPointerException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		stack.push("Hoang");
		stack.push("Evan");
		stack.push("Benmarc");
		
		assertTrue(stack.search("Evan") == 1);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNotFound() {
		stack.push("Hoang");
		stack.push("Evan");
		stack.push("Benmarc");
		
		assertTrue(stack.search("Jacque") == -1);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNull() {
		stack.push("Hoang");
		stack.push("Evan");
		stack.push("Benmarc");
		try {
			stack.search(null);
			fail("NullPointerException didn't throw");
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> stackIter = stack.iterator();
		assertFalse(stackIter.hasNext());
		try {
			stackIter.next();
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
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Benmarc");
		Iterator<String> stackIter = stack.iterator();
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
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Benmarc");
		stack.push("Evan");
		
		StackADT<String> compareStack = new MyStack<>();
		compareStack.push("Hoang");
		compareStack.push("Jacque");
		compareStack.push("Benmarc");
		compareStack.push("Evan");
		
		assertTrue(stack.equals(compareStack));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testNotEqualsStackADTOfE() {
		stack.push("Hoang");
		stack.push("Jacque");
		stack.push("Benmarc");
		stack.push("Evan");
		
		StackADT<String> compareStack = new MyStack<>();
		compareStack.push("Jacque");
		compareStack.push("Benmarc");
		compareStack.push("Evan");
		
		assertFalse(stack.equals(compareStack));
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		stack.push("Hoang");
		assertTrue(stack.size() == 1);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeNull() {
		assertFalse(stack.size() != 0);
	}

}
