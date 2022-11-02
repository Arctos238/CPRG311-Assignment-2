/**
 * 
 */
package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author phamh
 * @param <E>
 *
 */
public class MyStack<E> implements StackADT<E> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5020374182030896278L;
	private MyArrayList<E> stack;
	
	public MyStack() {
		stack = new MyArrayList<E>();
	}
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toAdd == null) {
			throw new NullPointerException();
		}
		stack.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		E element = stack.remove(stack.size() - 1); 
		if (element == null) {
			throw new EmptyStackException();
		} else {
			return element;
		}
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		E element = stack.get(stack.size() - 1);
		if (element == null) {
			throw new EmptyStackException();
		} else {
			return element;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stack.clear();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Object[] toArray() throws EmptyStackException{
		// TODO Auto-generated method stub
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException, EmptyStackException {
		// TODO Auto-generated method stub
		if (stack.size() == 0) {
			throw new EmptyStackException();
		}
		if (holder == null) {
			throw new NullPointerException();
		}
		return stack.toArray(holder);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toFind == null) {
			throw new NullPointerException();
		}
		return stack.contains(toFind);
	}

	@Override
	public int search(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
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

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return stack.iterator();
	}
	

	@Override
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

}
