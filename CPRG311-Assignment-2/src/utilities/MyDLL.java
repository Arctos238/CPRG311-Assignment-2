package utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * The Class MyDLL.
 *
 * @param <E> the element type
 */
public class MyDLL<E> implements ListADT<E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7140796753013938413L;

	/** The size. */
	private int size;

	/** The head. */
	private MyDLLNode<E> head;

	/** The tail. */
	private MyDLLNode<E> tail;

	/**
	 * Instantiates a new my DLL.
	 */
	public MyDLL() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Gets the head.
	 *
	 * @return the head node
	 */
	public MyDLLNode<E> getHead() {
		return head;
	}

	/**
	 * Gets the tail.
	 *
	 * @return the tail node
	 */
	public MyDLLNode<E> getTail() {
		return tail;
	}

	/**
	 * This method will provide the node at the location of the index
	 * It first search to see if the node at the index is in the
	 * first half or second half of the list.
	 * If its in the first half it will search there.
	 * And if its the second half it will search there.
	 * @param index of where the node is
	 * @return the node
	 */
	private MyDLLNode<E> returnNode(int index) {
		MyDLLNode<E> currentNode = head;

		int firstHalf = this.size() / 2;

		if (index <= firstHalf) {
			currentNode = this.head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next();
			}
		} else {
			currentNode = this.tail;
			for (int i = this.size() - 1; i > index; i--) {
				currentNode = currentNode.prev();
			}
		}

		return currentNode;
	}

	/**
	 * Size.
	 *
	 * @return the Size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Clears the list
	 */
	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	/**
	 * Adds the element to list
	 *
	 * @param index the index
	 * @param toAdd the to add
	 * @return true, if successful
	 * @throws NullPointerException      the null pointer exception
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (toAdd == null) {
			throw new NullPointerException();
		}
		if (head == null) {
			MyDLLNode<E> n = new MyDLLNode<E>(toAdd, null, null);
			n.setNext(n);
			n.setPrev(n);
			this.head = n;
			this.tail = n;
		} else {
			MyDLLNode<E> current = returnNode(index);
			// current points to MyDLLNode that will follow new MyDLLNode.

			MyDLLNode<E> n2 = new MyDLLNode<E>(toAdd, current, current.prev());
			current.prev().setNext(n2);
			current.setPrev(n2);
			// update first if necessary.
			if (index == 0) {
				this.head = n2;
			}
		}
		size++;
		return true;
	}

	/**
	 * Adds the element to the list
	 *
	 * @param toAdd the to add
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> newMyDLLNode = new MyDLLNode<E>(toAdd, null, null);

		if (head == null) {
			head = tail = newMyDLLNode;
			head.setPrev(null);
			tail.setNext(null);
		} else {
			tail.setNext(newMyDLLNode);
			newMyDLLNode.setPrev(tail);
			tail = newMyDLLNode;
			tail.setNext(null);
		}
		size++;
		return true;
	}

	/**
	 * Adds the all elements inside the toAdd list to this list
	 *
	 * @param toAdd the to add
	 * @return true, if successful
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
	 * Gets the element at the provided index
	 *
	 * @param index the index
	 * @return the e
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		MyDLLNode<E> current = returnNode(index);

		return current.getElement();
	}

	/**
	 * Removes the element at the provided index
	 *
	 * @param index the index of where the element is to delete
	 * @return the element removed at that index
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		MyDLLNode<E> removed = null;
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (this.head.getElement() == null) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			removed = this.head;
			this.head = this.head.next();
		} else {
			MyDLLNode<E> current = returnNode(index);
			removed = current;
			current.prev().setNext(current.next());
			current.next().setPrev(current.prev());
			current.setPrev(null);
			current.setNext(null);
		}
		size--;
		return removed.getElement();
	}

	/**
	 * Removes the first element that is equal to the element provided
	 *
	 * @param toRemove the to remove
	 * @return the element to removed or null
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		MyDLLNode<E> removed = null;
		MyDLLNode<E> current = this.head;
		if (toRemove == null) {
			throw new NullPointerException();
		} else if (head.getElement().equals(toRemove)) {
			head = head.next();
			head.setPrev(null);
		} else {
			for (int i = 0; removed == null && i < size; i++) {
				if (current.getElement().equals(toRemove)) {
					removed = current;
					current.prev().setNext(current.next());
					current.next().setPrev(current.prev());
					current.setPrev(null);
					current.setNext(null);
					size--;
				}

				current = current.next();
			}
		}
		

		if (removed == null) {
			return null;
		} else {
			return removed.getElement();
		}

	}

	/**
	 * Sets the element at the index provide to the element provide
	 *
	 * @param index    the index
	 * @param toChange the to change
	 * @return the element that was taken out of the node and replaced
	 * @throws NullPointerException      the null pointer exception
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E returnedElement = null;
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (this.head.getElement() == null) {
			throw new IndexOutOfBoundsException();
		} else if (toChange == null) {
			throw new NullPointerException();
		} else if (index == 0) {
			returnedElement = this.head.getElement();
			head.setElement(toChange);
		} else {
			MyDLLNode<E> current = returnNode(index);

			returnedElement = current.getElement();
			current.setElement(toChange);
		}

		return returnedElement;
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
	 * If the element contains the element provided it will return that element
	 * else it will return false
	 *
	 * @param toFind the to find
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		} else if (size == 0) {
			return false;
		} else {
			MyDLLNode<E> current = this.head;
			for (int i = 0; i < size; i++) {
				if (current.getElement().equals(toFind)) {
					return true;
				}

				current = current.next();
			}
		}
		return false;
	}

	/**
	 * Return an array of the type of element provided
	 *
	 * @param toHold the to hold
	 * @return the e[]
	 * @throws NullPointerException the null pointer exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		if (toHold == null) {
			throw new NullPointerException();

		} else if (toHold.length < size) {
			toHold = (E[]) new Object[size];
		}

		Iterator<E> it = iterator();
		int i = 0;
		while (it.hasNext()) {
			toHold[i] = it.next();
			i++;
		}

		return toHold;
	}

	/**
	 * Return an array of an object type
	 *
	 * @return the object[]
	 */
	@Override
	public Object[] toArray() {
		Object[] toHold = new Object[size];
		Iterator<E> it = iterator();
		int i = 0;
		while (it.hasNext()) {
			toHold[i] = it.next();
			i++;
		}

		return toHold;
	}

	/**
	 * Iterator that will iterate through the list
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyDDLIterator();
	}

	/**
	 * The Class MyDDLIterator.
	 */
	private class MyDDLIterator implements Iterator<E> {

		/** The current. */
		private MyDLLNode<E> current = getHead();

		/** The pos. */
		private int pos = 0;

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		/**
		 * Next.
		 *
		 * @return the e
		 * @throws NoSuchElementException the no such element exception
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (hasNext()) {
				E toReturn = get(pos);
				current = current.next();
				pos++;
				return toReturn;
			} else {
				throw new NoSuchElementException();
			}
		}

	}
}
