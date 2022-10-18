package utilities;

public interface StackADT<E> {

	public void push(E toAdd);

	public E pop();

	public E peek();

	public boolean equals(StackADT<E> that);

	public Iterator<E> iterator();

	public Object[] toArray();

	public E[] toArray(E[] copy);

	public int search(E obj);

	public boolean contains(E obj);

	public int size();

	public boolean isEmpty();

	public void clear();
}



