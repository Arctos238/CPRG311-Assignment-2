package utilities;

import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E>{
	private MyDLL<E> queue;
	private int maxSize;
	
	public MyQueue(){
		queue = new MyDLL<E>();
	}
	
	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new MyDLL<E>();
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		} else if (!isFull()) {
			queue.add(toAdd);
		}
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		} else {
			return queue.remove(0);
		}
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		} else {
			return queue.get(0);
		}
	}

	@Override
	public void dequeueAll() {
		queue.clear();
	}

	@Override
	public boolean isEmpty() {
		return queue.size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return queue.iterator();
	}

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

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) {
			throw new NullPointerException();
		}
		return queue.toArray(holder);
	}

	@Override
	public boolean isFull() {
		if (maxSize == 0) {
			return false;
		} else {
			return queue.size() == maxSize;
		}
	}

	@Override
	public int size() {
		return queue.size();
	}
	

}
