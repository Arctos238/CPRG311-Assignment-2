package utilities;


import java.util.NoSuchElementException;

/**
 * The Class MyArrayList.
 *
 */
public class MyArrayList<E> implements ListADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7494602786671125781L;

	/** The array. */
	private Object[] array;
	
	/** The size. */
	private int size;
	
	/** The default size. */
	private final int DEFAULT_SIZE = 10;

	/**
	 * Instantiates a new my array list.
	 */
	public MyArrayList() {

		array = new Object[DEFAULT_SIZE];

	}

	/**
	 * Returns the current size of the list
	 *
	 * @return int value of the current size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Clears the list by setting the array back to the default size and setting size to zero
	 */
	@Override
	public void clear() {
		array = new Object[DEFAULT_SIZE];
		size = 0;
	}

	/**
	 * Adds the element to the list using the index. Resizes the array if needed.
	 * Push all elements to the right of where they needed to be added
	 * @param index the index of where the element is to be added
	 * @param toAdd the to add to the list
	 * @return true, if successful and false if not successful
	 * @throws NullPointerException the null pointer exception if a null object is passed through
	 * @throws IndexOutOfBoundsException the index out of bounds exception if the index is greater then the list size or less then zero
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (toAdd == null) {
			throw new NullPointerException();
		}

		if (size >= array.length) {
			resize();
		}

		size++;
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = toAdd;
		return true;

	}

	/**
	 * Adds the element to the end of the list.
	 *
	 * @param toAdd the element to add
	 * @return true, if successful and false if unsuccessful
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		if (size >= array.length) {
			resize();
		} 

		array[size] = toAdd;
		size++;

		return true;

	}

	/**
	 * Adds the elements inside the list provided to the current list.
	 * If the list is equal to null then the NullPointereException is thrown
	 * @param toAdd the to list of elements to add
	 * @return true, if successful and false if not
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		return true;
	}

	/**
	 * Gets the element at the indexed location inside the array
	 * If the index is less then 0 or greater then the list size then 
	 * the indexOutOfBoundsException will be raised
	 * @param index the index of where the item is to get inside the array
	 * @return the element to return inside of the list
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (size == 0) {
			return null;
		} else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			return (E) array[index];
		}
	}

	/**
	 * Removes the element at that location and move each element to the left
	 * If the index is less then 0 or greater then the list size then 
	 * the indexOutOfBoundsException will be raised
	 * @param index the index
	 * @return the element that is to be removed from the list
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (size == 0) {
			return null;
		} else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			E toReturn = (E) array[index];
			for (int i = index; i < size - 1; i++) {
				array[i] = array[i + 1];
				if (index == size - 1) {
					array[index] = null;
				}
			}
			size--;
			return (E) toReturn;
		}
	}

	/**
	 * Removes the element that is equal to the one passed through.
	 * If the element passed through is not found then a null value is returned.
	 * If successful the element that was removed will be returned.
	 * @param toRemove the to remove
	 * @return the e
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (size == 0) {
			return null;
		} else {
			for (int i = 0; i < size; i++) {
				if (toRemove.equals(array[i])) {
					remove(i);
					return toRemove;
				}
			}
		}
		return null;
	}

	/**
	 * Sets the element inside the array to the new element provided.
	 * @param index the index where to set the element
	 * @param toChange the element to set
	 * @return the element to set
	 * @throws NullPointerException the null pointer exception
	 * @throws IndexOutOfBoundsException the index out of bounds exception if the index is greater the list size or less then zero
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (toChange == null) {
			throw new NullPointerException();
		} else if (size == 0) {
			return null;
		} else {
			E toReturn = (E) array[index];
			array[index] = toChange;
			return toReturn;
		}
	}

	/**
	 * Checks if is empty. 
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Contains this element return true or false
	 * Will search through the list
	 * @param toFind the to find
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (size == 0) {
			return false;
		} else if (toFind == null) {
			throw new NullPointerException();
		}

		else {
			for (int i = 0; i < size; i++) {
				if (toFind.equals(array[i])) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Will return an array of the type of the element.
	 *
	 * @param toHold the to hold
	 * @return the e[]
	 * @throws NullPointerException the null pointer exception if the array provided is null.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		} else if (size == 0) {
			return null;
		} else {
			if (toHold.length < size - 1) {
				toHold = (E[]) new Object[size];
			}

			for (int i = 0; i < size; i++) {
				toHold[i] = (E) array[i];
			}

			return toHold;
		}
	}

	/**
	 * Resizes the array so the array can input more elements. Resizes the array to
	 * 1.5 times the current size of the array.
	 */
	private void resize() {
		Object[] tempArray = new Object[(int) (size * 1.5)];

		for (int i = 0; i < size; i++) {
			tempArray[i] = array[i];
		}

		array = tempArray;
	}

	/**
	 * Return an array of the list as a super class object array.
	 *
	 * @return the object[]
	 */
	@Override
	public Object[] toArray() {
		return array;
	}

	/**
	 * Iterator. This will return an object that will iterator through the list
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}

	/**
	 * The Class MyArrayListIterator.
	 */
	private class MyArrayListIterator implements Iterator<E> {
		
		/** The pos. */
		private int pos;

		/**
		 * Checks for next element inside the list
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		/**
		 * Provides the next element inside the list
		 *
		 * @return the element
		 * @throws NoSuchElementException the no such element exception
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}

			E toReturn = (E) array[pos++];

			return toReturn;
		}

	}

}