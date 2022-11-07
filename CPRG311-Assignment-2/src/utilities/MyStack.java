/**
 * 
 */
package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * The Class MyStack.
 *
 * @author phamh
 * @param <E> the element type
 */
public class MyStack<E> implements StackADT<E> {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5020374182030896278L;
	
	/** The stack. */
	private MyArrayList<E> stack;
	
	/**
	 * Instantiates a new my stack.
	 */
	public MyStack() {
		stack = new MyArrayList<E>();
	}
	
	/**
	 * Pushes the element to the top of the stack
	 *
	 * @param toAdd the to add
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		stack.add(toAdd);
	}

	/**
	 * Pops the element of the top of the stack
	 *
	 * @return the e
	 * @throws EmptyStackException the empty stack exception
	 */
	@Override
	public E pop() throws EmptyStackException {
		E element = stack.remove(stack.size() - 1); 
		if (element == null) {
			throw new EmptyStackException();
		} else {
			return element;
		}
	}

	/**
	 * Peeks at the element on top of the stack
	 *
	 * @return the e
	 * @throws EmptyStackException the empty stack exception
	 */
	@Override
	public E peek() throws EmptyStackException {
		E element = stack.get(stack.size() - 1);
		if (element == null) {
			throw new EmptyStackException();
		} else {
			return element;
		}
	}

	/**
	 * Clears the stack of all elements
	 */
	@Override
	public void clear() {
		stack.clear();
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * To array.
	 *
	 * @return the object[]
	 * @throws EmptyStackException the empty stack exception
	 */
	@Override
	public Object[] toArray() throws EmptyStackException{
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		return stack.toArray();
	}

	/**
	 * To array.
	 *
	 * @param holder the holder
	 * @return the e[]
	 * @throws NullPointerException the null pointer exception
	 * @throws EmptyStackException the empty stack exception
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException, EmptyStackException {
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		if (holder == null) {
			throw new NullPointerException();
		}
		return stack.toArray(holder);
	}

	/**
	 * If the element provides is inside the stack it returns true, otherwise false.
	 *
	 * @param toFind the to find
	 * @return true, if successful
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		return stack.contains(toFind);
	}

	/**
	 * Searchs the stack for the elemented provided
	 *
	 * @param toFind the to find
	 * @return the int
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public int search(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		Iterator<E> stackIter = stack.iterator();
		while (stackIter.hasNext()) {
			if (toFind.equals(stackIter.next())) {
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return stack.iterator();
	}
	

	/**
	 * Equals.
	 *
	 * @param that the that
	 * @return true, if successful
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		StackADT<E> auxStack = new MyStack<>();
		boolean equal = true;
		while(!stack.isEmpty() && !that.isEmpty()) {
			E first = stack.remove(stack.size() - 1);
			E second = that.pop();
			auxStack.push(first);
			auxStack.push(second);
			if (first != second) {
				equal = false;
				break;
			}
		}
		
		if (!(stack.isEmpty()) || !(that.isEmpty())) {
			equal = false;
		}
		
		while (!auxStack.isEmpty()) {
			that.push(auxStack.pop());
			stack.add(auxStack.pop());
		}
		return equal;
	}

	/**
	 * Size.
	 *
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		return stack.size();
	}

}
