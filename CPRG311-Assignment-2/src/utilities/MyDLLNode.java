package utilities;

public class MyDLLNode<E> {
	private E element;
	private MyDLLNode<E> next;
	private MyDLLNode<E> prev;

	public MyDLLNode(E element, MyDLLNode<E> next, MyDLLNode<E> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	public MyDLLNode(E element) {
		this.element = element;
	};
	
	public E getElement(){
		return element;
	}
	
	public void setElement(E element){
		this.element = element;
	}
	
	public MyDLLNode<E> next() {
		return this.next;
	}
	
	public MyDLLNode<E> prev() {
		return this.prev;
	}
	
	public void setNext(MyDLLNode<E> node) {
		this.next = node;
	}
	
	public void setPrev(MyDLLNode<E> node) {
		this.prev = node;
	}
}
