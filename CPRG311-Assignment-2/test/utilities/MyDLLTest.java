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
class MyDLLTest {
	ListADT<String> list;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSize() {
		 assertFalse(list.size() != 0);
		 
		 list.add("J");
		 
		 assertTrue(list.size() == 1);
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	void testClear() {
		assertFalse(list.size() != 0);
		list.add("A");
		list.add("B");
		
		list.clear();
		assertTrue(list.size() == 0);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntE() {
		assertFalse(list.size() != 0);
		list.add(0, "A");
		
		assertTrue(list.get(0).equals("A"));
		list.clear();
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		String[] strings = {"A", "B", "C", "D"};		
		
		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i]);
		}
		
		for (int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).equals(strings[i]));
		}
		
		
		assertFalse(list.get(0).equals("D"));
		assertTrue(list.get(0).equals("A"));
		list.clear();
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
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGet() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertFalse(list.get(0).equals("D"));
		assertTrue(list.get(0).equals("A"));	
	
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		list.remove(0);
		assertFalse(list.get(0).equals("A"));
		assertTrue(list.get(0).equals("B"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.remove("B");
		assertFalse(list.get(1).equals("B"));
		assertTrue(list.size() == 2);
		
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.set(1, "Z");
		
		assertTrue(list.contains("Z"));
		assertTrue(list.get(1) == "Z");
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
