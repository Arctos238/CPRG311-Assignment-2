package utilities;

/**
 * The Class MyDLLNode.
 *
 * @param <E> the element type
 */
public class MyDLLNode<E> {
	
	/** The element. */
	private E element;
	
	/** The next. */
	private MyDLLNode<E> next;
	
	/** The prev. */
	private MyDLLNode<E> prev;

	/**
	 * Instantiates a new my DLL node.
	 *
	 * @param element the element
	 * @param next the next
	 * @param prev the prev
	 */
	public MyDLLNode(E element, MyDLLNode<E> next, MyDLLNode<E> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}


	
	/**
	 * Gets the element inside this node
	 *
	 * @return the element
	 */
	public E getElement(){
		return element;
	}
	
	/**
	 * Sets the element inside this node
	 *
	 * @param element the new element
	 */
	public void setElement(E element){
		this.element = element;
	}
	
	/**
	 * Returns the next node linked to this list
	 *
	 * @return the my DLL node
	 */
	public MyDLLNode<E> next() {
		return this.next;
	}
	
	/**
	 * Returns the previous node linked to this list
	 *
	 * @return the my DLL node
	 */
	public MyDLLNode<E> prev() {
		return this.prev;
	}
	
	/**
	 * Sets the next node
	 *
	 * @param node the new next
	 */
	public void setNext(MyDLLNode<E> node) {
		this.next = node;
	}
	
	/**
	 * Sets the previous node
	 *
	 * @param node the new prev
	 */
	public void setPrev(MyDLLNode<E> node) {
		this.prev = node;
	}
}
