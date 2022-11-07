/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author J.Pointer
 *
 */
class MyDLLTests {

	/** The list. */
	MyDLL<String> list;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#MyDLL()}
	 */
	@Test
	void testMyDLL() {
		MyDLL<String> mydll = new MyDLL<>();

		assertFalse(mydll == null);
	}

	/**
	 * Test method for {@link utilities.MyDLL#MyDLL()}
	 */
	@Test
	void testGetHead() {
		String expectedValue = "A";

		assertEquals(list.getHead(), null);

		list.add(expectedValue);
		list.add("B");
		list.add("C");

		assertEquals(list.getHead().getElement(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#MyDLL()}
	 */
	void testGetTail() {
		String expectedValue = "C";

		assertEquals(list.getTail(), null);

		list.add("A");
		list.add("B");
		list.add(expectedValue);

		assertEquals(list.getTail().getElement(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeIsZero() {
		int expectedValue = 0;

		assertEquals(list.size(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeIsNotZero() {
		int expectedValue = 5;

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		assertEquals(list.size(), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	void testClear() {
		int expectedValue = 0;

		list.add("A");
		list.add("B");

		list.clear();
		assertEquals(list.size(), expectedValue);
		assertEquals(list.getHead(), null);
		assertEquals(list.getTail(), null);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntE() {
		String expectedValueOne = "A";
		String expecetedValueTwo = "Z";
		String expectedValueThree = "B";
		String expectedValueFour = "G";

		list.add(expectedValueOne);
		list.add(expectedValueThree);
		list.add(expectedValueFour);

		list.add(1, expecetedValueTwo);

		assertEquals(list.get(0), expectedValueOne);
		assertEquals(list.get(1), expecetedValueTwo);
		assertEquals(list.get(2), expectedValueThree);
		assertEquals(list.get(3), expectedValueFour);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointerException() {
		list.add("A");
		list.add("B");
		list.add("C");

		try {
			list.add(0, null);
			fail("NullPointerException was not thrown ");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsException() {
		list.add("A");
		list.add("B");
		list.add("C");

		try {
			list.add(10, "G");
			fail("IndexOutOfBoundsException was not thrown ");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		String expectedValue = "A";

		list.add(expectedValue);

		assertEquals(list.get(0), expectedValue);

	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointerException() {
		list.add("A");

		try {
			list.add(null);
			fail("NullPointerException was not thrown ");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@SuppressWarnings("null")
	@Test
	void testAddAll() {
		ListADT<String> toInsert = new MyDLL<>();

		list.add("AB");
		toInsert.add("A");

		list.addAll(toInsert);
		assertTrue(list.get(1).equals("A"));
		assertFalse(list.get(0).equals(toInsert.get(0)));
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@SuppressWarnings("null")
	@Test
	void testAddAllNullPointerException() {
		ListADT<String> toInsert = null;

		try {
			list.addAll(toInsert);
			fail("NullPointerException was not thrown ");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGet() {
		String expectedValue = "A";

		list.add(expectedValue);
		list.add("B");
		list.add("C");
		list.add("D");

		assertFalse(list.get(0).equals("D"));
		assertEquals(list.get(0), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBoundsException() {
		list.add("B");
		list.add("C");

		try {
			list.get(10);
			fail("IndexOutOfBoundsException was not thrown");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		String expectedValue = "A";
		
		list.add(expectedValue);
		list.add("B");
		list.add("C");
		list.add("D");

		assertEquals(list.remove(0), expectedValue);
		assertFalse(list.get(0).equals("A"));
		assertTrue(list.get(0).equals("B"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testRemoveIntIndexOutOfBoundsException() {
		list.add("B");
		list.add("C");

		try {
			list.remove(10);
			fail("IndexOutOfBoundsException was not thrown");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		String expectedValueOne = "B";
		int expectedValueTwo = 2;
		
		list.add("A");
		list.add(expectedValueOne);
		list.add("C");
		
		assertEquals(list.remove("G"), null);
		assertEquals(list.remove(expectedValueOne), expectedValueOne);
		assertEquals(list.size(), expectedValueTwo);

	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENullPointerException() {
		list.add("A");
		
		try {
			list.remove(null);
			fail("NullPointerException was not thrown ");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}


	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		String expectedValue = "Z";
		
		list.add("A");
		list.add("B");
		list.add("C");

		list.set(1, expectedValue);

		assertTrue(list.contains(expectedValue));
		assertEquals(list.get(1), expectedValue);
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNull() {
		list.add("A");
		list.add("B");
		list.add("C");

		try {
			list.set(1, null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetOutOfBounds() {
		list.add("A");
		list.add("B");
		list.add("C");

		try {
			list.set(4, "X");
			fail("Didn't throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
		
		list.add("B");
		list.add("A");
		list.add("C");
		
		list.clear();
		
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsNotEmpty() {
		list.add("A");
		assertFalse(list.isEmpty());
	}


	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		list.add("A");
		list.add("B");
		list.add("C");

		assertTrue(list.contains("A"));
		assertFalse(list.contains("H"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNull() {
		try {
			list.contains(null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		String[] arrayTest = new String[4];
		arrayTest[0] = "A";
		arrayTest[0] = "B";
		arrayTest[0] = "C";
		arrayTest[0] = "D";

		String[] array = new String[list.size()];
		list.toArray(array);

		assertTrue(array != null);
		assertTrue(array[0].equals("A"));
		assertTrue(array.getClass() == arrayTest.getClass());

		Object[] objectArray = new Object[10];
		assertFalse(array.getClass() == objectArray.getClass());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayENullValue() {
		try {
			list.toArray(null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArray() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		Object[] objectArray = list.toArray();

		assertTrue(objectArray != null);
		assertTrue(objectArray[0].equals("A"));

		String[] arrayTest = new String[4];
		assertFalse(objectArray.getClass() == arrayTest.getClass());
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testIterator() {
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		int i = 0;
		while (it.hasNext()) {
			assertEquals(list.get(i++), it.next());
		}
		assertFalse(it.hasNext());

		try {
			it.next();
			fail("NoSuchElementException didn't throw");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test iterator empty.
	 */
	void testIteratorEmpty() {
		Iterator<String> it = list.iterator();
		assertFalse(it.hasNext());
		try {
			it.next();
			fail("NoSuchElementException didn't throw");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

}
