package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;

	private int size;
	private Node<E> head;
	private Node<E> tail;

	@SuppressWarnings("hiding")
	private class Node<E> {
		private E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element, Node<E> next, Node<E> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		public Node(E element) {
			this.element = element;
		};
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (toAdd == null) {
			throw new NullPointerException();
		}
		if (head == null) {
			Node<E> n = new Node<E>(toAdd, null, null);
			n.next = n;
			n.prev = n;
			this.head = n;
			this.tail = n;
		} else {
			Node<E> current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			// current points to node that will follow new node.

			Node<E> n2 = new Node<E>(toAdd, current, current.prev);
			current.prev.next = n2;
			current.prev = n2;
			// update first if necessary.
			if (index == 0) {
				this.head = n2;
			}
		}
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		Node newNode = new Node(toAdd);

		if (head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
		}
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> current;

		int firstHalf = this.size() / 2;

		if (index <= firstHalf) {
			current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = this.tail;
			for (int i = this.size() - 1; i > index; i--) {
				current = current.prev;
			}
		}
		return (E) current.element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node<E> removed = null;
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (this.head.element == null) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			this.head = this.head.next;
		} else {
			Node<E> current = this.head.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
				removed = current;
			}
			current.next = current.next.next;
		}
		size--;
		return (E) removed;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		Node<E> removed = null;
		Node<E> current = this.head;
		if (toRemove == null) {
			throw new NullPointerException();
		} else {

			for (int i = 0; i <= size; i++) {
				if (current.element.equals(toRemove)) {
					removed = current;
					current.prev.next = current.next;
					current.next.prev = current.prev;
//					current.prev = null;
//					current.next = null;
					break;
				}

				current = current.next;
			}
		}
		size--;
		return removed.element;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E returnedElement = null;
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (this.head.element == null) {
			throw new IndexOutOfBoundsException();
		} else if (toChange == null) {
			throw new NullPointerException();
		} else if (index == 0) {
			returnedElement = this.head.element;
			head.element = toChange;
		} else {
			Node<E> current = this.head;
			int i = 0;

			while (i < index) {
				current = current.next;
				i++;
			}

			returnedElement = current.element;
			current.element = toChange;
		}

		return returnedElement;
	}

	@Override
	public boolean isEmpty() {
		if (this.head == null && this.tail == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		} else if (size == 0) {
			return false;
		} else {
			Node<E> current = this.head;
			for (int i = 0; i < size; i++) {
				if (current.element.equals(toFind)) {
					return true;
				}

				current = current.next;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		if (toHold == null) {
			throw new NullPointerException();

		} else if (toHold.length < size) {
			toHold = (E[]) new Object[size];
		}

		Iterator it = iterator();
		int i = 0;
		while (it.hasNext()) {
			toHold[i] = (E) it.next();
			i++;
		}

		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] toHold = new Object[size];
		Iterator it = iterator();
		int i = 0;
		while (it.hasNext()) {
			toHold[i] = (E) it.next();
			i++;
		}

		return toHold;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyDDLIterator();
	}

	private class MyDDLIterator implements Iterator<E> {
		private Node<E> current = head;
		private int pos = 0;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (hasNext()) {
				E toReturn = get(pos);
				current = current.next;
				pos++;
				return toReturn;
			} else {
				throw new NoSuchElementException();
			}
		}

	}
}
