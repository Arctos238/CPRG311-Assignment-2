/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Arcto
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
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
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
		list.clear();
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
		list.clear();
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

}
