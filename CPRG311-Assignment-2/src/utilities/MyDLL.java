package utilities;

public class MyDLL<E> implements ListADT<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140796753013938413L;

	private class Node{
		E element;
		Node head;
		Node tail;
		
		public Node(E element, Node head, Node tail){
			this.element = element;
			this.head = head;
			this.tail = tail;
		}
	}

	@Override
	public int size() {
		int res = 0;
		while (node != null){
			res++;
			node = node.next;
		}
		return res;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > numElements) 
		throw new InvalidArgumentException();
		Node<E> newNode = new Node<E>(element);
		if (head == null) {	
			head = newNode;
			tail = newNode;
		}
		else if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else if (index == numElements) {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		else {	
			Node<E> nodeRef = head;
			for (int i = 1; i < index; i++) 
				nodeRef = nodeRef.next;
			newNode.next = nodeRef.next;
			nodeRef.next = newNode;
			newNode.prev = nodeRef;
			newNode.next.prev = newNode;
		}
		numElements++;
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (isEmpty()) {
            System.out.println("List is empty");
            return false;
        }

        Node curr = head;
        while(curr != null && curr.data != key) {
            curr = curr.next;
        }

        if (curr == null) {
            return false;
        }

        return true;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		 if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        // find the position of the key
        Node curr = head;

        while(curr != null && curr.data != key) {
            curr = curr.next;
        }

        if(curr == null) {
            System.out.print("key not found");
            return;
        }

        if (curr.prev == null) {
            popFront();

        } else if (curr.next == null) { // if curr is last item
            popBack();

        } else { //anywhere between first and last node
            Node next = curr.next;
            Node prev = curr.prev;

            prev.next = next;
            next.prev = prev;

            curr.prev = null;
            curr.next = null;
            curr = null;
        }
		return true;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
