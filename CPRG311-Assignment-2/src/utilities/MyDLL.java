package utilities;


public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;
//	
	private int size;
	private Node head;
	private Node tail;
	
	private class Node<E>
	{
	    private E data;
	    private Node next;
	    private Node prev;

	    public Node(E data, Node next, Node prev)
	    {
	        this.data = data;
	        this.next = next;
	        this.prev = prev;
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

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index > size || index < 0)
	    {
	        throw new IndexOutOfBoundsException();
	    }
	    if (head == null)
	    {
	        Node n = new Node(toAdd, null, null);
	        n.next = n;
	        n.prev = n;
	        head = n;
	    }
	    else
	        {
	        Node current = head;
	        for (int i = 0; i < index; i++)
	        {
	            current = current.next;
	        }
	        //current points to node that will follow new node.
	        
			Node n2 = new Node(toAdd, current, current.prev);
	        current.prev.next = n2;
	        current.prev = n2;
	        //update first if necessary.
	        if(index == 0)
	        {
	            head = n2;
	        }
	    }
	    size++;
	    return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (head == null)
	    {
	        head = new Node(toAdd, null, null);
	        head.next = head;
	        head.prev = head;
	    }
	    else
	        {
	        head.prev.next = new Node(toAdd, head, head.prev);
	        head.prev = head.prev.next;
	    }
	    size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
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
