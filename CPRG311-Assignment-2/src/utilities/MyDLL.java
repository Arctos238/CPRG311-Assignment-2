package utilities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import javax.lang.model.element.Element;

public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;

	
	private int size;
	private Node<E> head;
	private Node<E> tail;

	@SuppressWarnings("hiding")
	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;

		public Node(E element, Node<E> next, Node<E> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		public Node(ListADT<? extends E> toAdd) {
			// TODO Auto-generated constructor stub
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index > size || index < 0)
	    {
	        throw new IndexOutOfBoundsException();
	    }
	    if (head == null)
	    {
	        Node<E> n = new Node<E>(toAdd, null, null);
	        n.next = n;
	        n.prev = n;
	        this.head = n;
	        this.tail = n;
	    }
	    else
	        {
	        Node<E> current = this.head;
	        for (int i = 0; i < index; i++)
	        {
	            current = current.next;
	        }
	        //current points to node that will follow new node.
	        
			Node<E> n2 = new Node<E>(toAdd, current, current.prev);
	        current.prev.next = n2;
	        current.prev = n2;
	        //update first if necessary.
	        if(index == 0)
	        {
	            this.head = n2;
	        }
	    }
	    size++;
	    return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
        if (this.head == null) {
            this.head = new Node<E>(toAdd, null, null);
            this.head.next = head;
            this.head.prev = head;
            this.tail = head;
            this.tail.next = head;
            this.tail.prev = head;

        } else {
            this.head.prev.next = new Node<E>(toAdd, head, head.prev);
            this.head.prev = head.prev.next;
            this.tail.prev = this.tail;
            this.tail = head.prev.next;
        }
        size++;
        return true;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		for(int i = 0; i < toAdd.size(); i++) {
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
			for (int i = this.size()-1; i > index; i--) {
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
		Node<E> current = this.head.next;
		if(toRemove == null) {
			throw new NullPointerException();
		}else{
			
		for (int i = 0; i <= size; i++) {
			if (current.equals(toRemove)) {
				removed = current;
				current.prev = current.next;
				current.next = current.prev;
				break;
			}

			current = current.next;
		}
		}
		size--;
		return (E) removed;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} if (index > size) {
			throw new IndexOutOfBoundsException();
		} if (this.head.element == null) {
			throw new IndexOutOfBoundsException();
		} else if (toChange == null){ 
			throw new NullPointerException();
		}else if (index == 0) {
			remove(index);
			
			add(index, toChange);
		} else {
			remove(index);
			
			add(index, toChange);
		}
		
		return toChange;
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
		if (toFind == null){
			throw new NullPointerException();
		}else if(size == 0) {
			return false;
		} else {
			Node<E> current = this.head.next;
			for (int i = 0; i <= size; i++) {
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
		Node<E> current = head.next;
		private int pos;

		@Override
		public boolean hasNext() {
			return pos < size ;
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
