package utilities;

import java.util.ArrayList;

public class MyDLL<E> implements ListADT<E> {
	private static final long serialVersionUID = -7140796753013938413L;

	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	@SuppressWarnings("hiding")
	private class Node<E>
	{
	    private E element;
	    private Node<E> next;
	    private Node<E> prev;

	    public Node(E element, Node<E> next, Node<E> prev)
	    {
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
		if (this.head == null)
	    {
	        this.head = new Node<E>(toAdd, null, null);
	        this.head.next = head;
	        this.head.prev = head;
	    }
	    else
	        {
	        this.head.prev.next = new Node<E>(toAdd, head, head.prev);
	        this.head.prev = head.prev.next;
	    }
	    size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		Node<E> temp = new Node<E>(toAdd);
		add((E) temp);
		while(temp != null) {
			add((E) temp.next);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		 if(index < 0)
		    {
		        throw new IndexOutOfBoundsException();
		    }
		    if(index > size)
		    {
		        throw new IndexOutOfBoundsException();
		    }
		    Node<E> current = this.head;
		    for (int i = 0; i < index; i++)
		    {
		        current = current.next;
		    }
		    return (E) current.element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		Node<E> removed = null;
		 if(index < 0)
		    {
		        throw new IndexOutOfBoundsException();
		    }
		    if(index > size)
		    {
		        throw new IndexOutOfBoundsException();
		    }
		    if (this.head.element == null)
		    {
		        throw new IndexOutOfBoundsException();
		    }
		    else if (index == 0)
		    {
		        this.head = this.head.next;
		    }
		    else
		        {
		            Node<E> current = this.head.next;
		            for (int i = 0; i < index; i++){
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
		for(int i = 0; i <= size; i++) {
			if(current.equals(toRemove)) {
				removed = current;
				current.prev = current.next;
				current.next = current.prev;
				break;
			}
			
			current = current.next;
		}
		size--;	
		return (E) removed;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		Node<E> changeTo = null;
		Node<E> current = this.head.next;
		if(index < 0) {
	        throw new IndexOutOfBoundsException();
	        
	    } if(index > size) {
	        throw new IndexOutOfBoundsException();
	        
	    } if (this.head.element == null) {
	        throw new IndexOutOfBoundsException();
	        
	    } else if (index == 0) {
	        this.head = this.head.next;
	        
	    }else{
	    	for(int i = 0; i < index; i++) {
	    		current = current.next;	
	    	}
	    	
	    	current.element = toChange;
	    	
	    }
		return (E) changeTo;
	}

	@Override
	public boolean isEmpty() {
		if(this.head.equals(null) && this.tail.equals(null)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		Node<E> current = this.head.next;
		for(int i = 0; i <= size; i++) {
			if(current.equals(toFind)) {
				return true;
			}
			
			current = current.next;
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		ArrayList<E> arr = new ArrayList<E>();
		Node<E> current = this.head.next;
		
		for(int i = 0; i <= size; i++) {
			if(!current.element.equals(toHold)) {
				arr.add(current.element);
				current = current.next;
			}else{
				break;
			}
		}
		
		return null; //Come back to later about value to return
	}

	@Override
	public Object[] toArray() {
		ArrayList<E> arr = new ArrayList<E>();
		Node<E> current = this.head.next;
		
		for(int i = 0; i <= size; i ++) {
			arr.add(current.element);
			current = current.next;
		}
		return null; //Come back to later about value to return
	}

	@Override
	public Iterator<E> iterator() {
		ArrayList<E> arr = new ArrayList<E>();
		Node<E> current = this.head.next;
		
		for(int i = 0; i <= size; i ++) {
			arr.add(current.element);
			current = current.next;
		
		}
		
		java.util.Iterator<E> iterator = arr.iterator();
		
		
		return (Iterator<E>) iterator;
	}




	
}
