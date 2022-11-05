package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;

	private int size;
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;

	public MyDLL() {
		size = 0;
		head = null;
		tail = null;
	}

	public MyDLLNode<E> getHead() {
		return head;
	}

	public MyDLLNode<E> getTail() {
		return tail;
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
			MyDLLNode<E> current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next();
			}
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
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> newMyDLLNode = new MyDLLNode<E>(toAdd);

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

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> current;

		int firstHalf = this.size() / 2;

		if (index <= firstHalf) {
			current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next();
			}
		} else {
			current = this.tail;
			for (int i = this.size() - 1; i > index; i--) {
				current = current.prev();
			}
		}
		return current.getElement();
	}

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
			MyDLLNode<E> current = this.head.next();
			for (int i = 0; i < index; i++) {
				current = current.next();
			}
			removed = current;
			current.prev().setNext(current.next());
			current.next().setPrev(current.prev());
			current.setPrev(null);
			current.setNext(null);
		}
		size--;
		return removed.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		MyDLLNode<E> removed = null;
		MyDLLNode<E> current = this.head;
		if (toRemove == null) {
			throw new NullPointerException();
		} else {
			for (int i = 0; removed == null && i <= size; i++) {
				if (current.getElement().equals(toRemove)) {
					removed = current;
					current.prev().setNext(current.next());
					current.next().setPrev(current.prev());
					current.setPrev(null);
					current.setNext(null);
				}

				current = current.next();
			}
		}
		size--;
		return removed.getElement();
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
		if (this.head.getElement() == null) {
			throw new IndexOutOfBoundsException();
		} else if (toChange == null) {
			throw new NullPointerException();
		} else if (index == 0) {
			returnedElement = this.head.getElement();
			head.setElement(toChange);
		} else {
			MyDLLNode<E> current = this.head;
			int i = 0;

			while (i < index) {
				current = current.next();
				i++;
			}

			returnedElement = current.getElement();
			current.setElement(toChange);
		}

		return returnedElement;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

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

	@Override
	public Iterator<E> iterator() {
		return new MyDDLIterator();
	}

	private class MyDDLIterator implements Iterator<E> {
		private MyDLLNode<E> current = getHead();
		private int pos = 0;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

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
