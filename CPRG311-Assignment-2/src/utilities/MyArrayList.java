package utilities;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6641976547739553233L;

	private Object[] array;
	private int size;

	public MyArrayList() {
		array = new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		array = new Object[10];
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index >= size) {
			return false;
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

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (size >= array.length) {
			resize();
		}

		array[size] = toAdd;
		size++;

		return true;

	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (size == 0) {
			return null;
		} else if (index >= size) {
			return null;
		} else {
			return (E) array[index];
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (size == 0) {
			return null;
		} else if (index >= size) {
			return null;
		} else {
			Object toReturn = array[index];
			for (int i = index; i < size; i++) {
				array[i] = array[i + 1];
				if (index == size - 1) {
					array[index] = null;
				}
			}
			size--;
			return (E) toReturn;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (size == 0) {
			return null;
		} else {
			for (int i = 0; i < size; i++) {
				if(((E)array[i]).equals(toRemove)) {
					remove(i);
					return toRemove;
				}
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index >= size) {
			return null;
		} else if (size == 0) {
			return null;
		} else {
			E toReturn = (E) array[index];
			array[index] = toChange;
			return toReturn;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (size == 0) {
			return false;
		} else {
			for (int i = 0; i < size; i++) {
				if (array[i].equals(toFind)) {
					return true;
				}
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (size == 0) {
			return null;
		} else {
			if(toHold.length < size - 1) {
				toHold = (E[]) new Object[size];
			}
			
			for(int i = 0; i < size; i++) {
				toHold[i] = (E) array[i];
			}
			
			return toHold;
		}
	}
	
	/**
	 * Resizes the array so the array can input more elements. Resizes the array
	 * to 1.5 times the current size of the array.
	 */
	private void resize() {
		Object[] tempArray = new Object[(int) (size * 1.5)];

		for (int i = 0; i < size; i++) {
			tempArray[i] = array[i];
		}

		array = tempArray;
	}

	@Override
	public Object[] toArray() {
		return array;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements Iterator<E> {
		private int pos;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

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