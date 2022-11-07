package utilities;

import exceptions.EmptyQueueException;

/**
 * The Class MyQueue.
 *
 * @param <E> the element type
 */
public class MyQueue<E> implements QueueADT<E>{
	
	/** The queue. */
	private MyDLL<E> queue;
	
	/** The max size. */
	private int maxSize;
	
	/**
	 * Instantiates a new my queue.
	 */
	public MyQueue(){
		queue = new MyDLL<E>();
	}
	
	/**
	 * Instantiates a new my queue.
	 *
	 * @param maxSize the max size
	 */
	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new MyDLL<E>();
	}

	/**
	 * Enqueue adds an element to the queue
	 *
	 * @param toAdd the to add
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		} else if (!isFull()) {
			queue.add(toAdd);
		}
	}

	/**
	 * Dequeue removes the element from the queue
	 *
	 * @return the element that was removed
	 * @throws EmptyQueueException the empty queue exception
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		} else {
			return queue.remove(0);
		}
	}

	/**
	 * Peeks the queue to see what element is next to come out
	 *
	 * @return the element that is next to come out of the queue
	 * @throws EmptyQueueException the empty queue exception if no element is there
	 */
	@Override
	public E peek() throws EmptyQueueException {
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		} else {
			return queue.get(0);
		}
	}

	/**
	 * Remove all elements from the queue
	 */
	@Override
	public void dequeueAll() {
		queue.clear();
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		return queue.size() == 0;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return queue.iterator();
	}

	/**
	 * Equals. If another list is equal to this queue
	 *
	 * @param that the that
	 * @return true, if successful
	 */
	@Override
	public boolean equals(QueueADT<E> that) {
		if (that.size() != queue.size()) {
			return false;
		} else {
			Iterator<E> thisIt = this.queue.iterator();
			Iterator<E> thatIT = that.iterator();
			
			while(thisIt.hasNext()) {
				if(!thisIt.next().equals(thatIT.next())) {
					return false;
				}
			}
			
			return true;
		}
	}

	/**
	 * Return the queue as an array of type Object
	 *
	 * @return the object[]
	 */
	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	/**
	 * Returns an the queue as an array of the type of the element provided
	 *
	 * @param holder the holder
	 * @return the e[]
	 * @throws NullPointerException the null pointer exception
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) {
			throw new NullPointerException();
		}
		return queue.toArray(holder);
	}

	/**
	 * Checks if is full.
	 *
	 * @return true, if is full
	 */
	@Override
	public boolean isFull() {
		if (maxSize == 0) {
			return false;
		} else {
			return queue.size() == maxSize;
		}
	}

	/**
	 * Size.
	 *
	 * @return the size of the queue
	 */
	@Override
	public int size() {
		return queue.size();
	}
	

}
