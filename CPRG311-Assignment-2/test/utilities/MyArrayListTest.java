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
class MyArrayListTest {
	
	ListADT<String> list;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
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
		} catch(NoSuchElementException e){
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
		while(it.hasNext()) {
			assertEquals(list.get(i++), it.next());
		}
		assertFalse(it.hasNext());
		
		
		try {
			it.next();
			fail("NoSuchElementException didn't throw");
		} catch(NoSuchElementException e){
			assertTrue(true);
		}
	}

}
