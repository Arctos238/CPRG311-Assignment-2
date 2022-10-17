package utilities;

public interface QueueADT<E> {

	public void enqueue(E toAdd);

	public E dequeue();

	public E peek();

	public boolean equals(QueueADT<E> that);

	public Iterator<E> iterator();

	public Object[] toArray();

	public E[] toArray(E[] copy);

	public boolean isFull();

	public int size();

	public void dequeueAll();
}
