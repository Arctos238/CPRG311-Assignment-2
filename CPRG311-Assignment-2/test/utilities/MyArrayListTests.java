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
 * The Class MyArrayListTests.
 *
 * @author J.Pointer
 */
class MyArrayListTests {

	/** The list. */
	ListADT<String> list;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();

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
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeIsNull() {
		assertFalse(list.size() != 0);

		list.add("A");
		list.clear();

		assertFalse(list.size() != 0);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeIsNotNull() {
		list.add("A");
		assertTrue(list.size() == 1);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClear() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		list.clear();

		assertFalse(list.size() != 0);
		assertFalse(list.get(0) != null);

	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntE() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		list.add(2, "G");

		assertFalse(list.get(2).equals("C"));
		assertTrue(list.get(2).equals("G"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointerException() {
		list.add("s");
		try {
			list.add(0, null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsException() {
		try {
			list.add(25, "S");
			fail("Didn't throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEMinusIndexOutOfBoundsException() {
		try {
			list.add(-5, "S");
			fail("Didn't throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		list.add("A");
		assertTrue(list.get(0) != null);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointerException() {
		try {
			list.add(null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		ListADT<String> listTwo = new MyArrayList<>();
		listTwo.add("A");
		listTwo.add("B");
		listTwo.add("C");

		list.addAll(listTwo);
		assertTrue(list.size() == 3);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllNullPointerException() {
		try {
			list.addAll(null);
			fail("Didn't Throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		assertFalse(list.get(0).equals("B"));
		assertTrue(list.get(0).equals("A"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBounds() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		try {
			list.get(8);
			fail("Didn't throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIndex() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		list.remove(2);
		assertFalse(list.contains("C"));
		assertFalse(list.get(2).equals("C"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIndexOutOfBound() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		try {
			list.remove(9);
			fail("Didn't throw the IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		list.remove("B");

		assertFalse(list.contains("B"));
		assertFalse(list.get(1).equals("B"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENull() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		try {
			list.remove(null);
			fail("NullPointerException Didn't fail");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		list.set(2, "K");
		assertFalse(list.get(2).equals("C"));
		assertTrue(list.get(2).equals("K"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNull() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		try {
			list.set(0, null);
			fail("Didn't throw NullPointerException");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetIndexOutOfBounds() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		try {
			list.set(8, "O");
			fail("Didn't throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsNotEmpty() {
		list.add("A");

		assertFalse(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testDoesContain() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		assertTrue(list.contains("A"));

	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testDoesNotContains() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		assertFalse(list.contains("G"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNull() {
		list.add("A");
		try {
			list.contains(null);
			fail("NullPointerException didn't get Caught");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
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
	 * Test method for {@link utilities.MyArrayList#toArray()}.
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
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
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

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() {
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
	 * Test method for {@link utilities.MyArrayList#resize(int, java.lang.Object)}.
	 * Triggers the resize method inside of the ArrayList
	 */
	@Test
	void testResize() {
		for (int i = 0; i < 15; i++) {
			list.add("a " + i);
		}
		assertTrue(list.get(14) != null);
	}

}
