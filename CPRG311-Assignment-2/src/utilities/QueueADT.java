package utilities;

public interface QueueADT<E> {
	
	/**  
		The enqueue method will add one specified element to the end of a queue of elements. We can use to push operation to add the element to the end of the queue of elements.
		
		@param toAdd
			A type E object that will be added to the end of the sequenece 
		@return
			This method will return a argument that will be pushed as a perameter
	*/

	public void enqueue(E toAdd);
	/**
		The dequeue method will remove the first element of the queue. This function will throw NoSuchElementException  when the queue has no elements within the queue
		
		@return
			This method will return the element that has been removed
	
	*/

	public E dequeue();
	/**
		The peek method will view the first element of the queue without the programming having to remove the element afterwards. Will return null if the queue is empty
		
		@return
			This method will return the first element of the queue
		
	*/

	public E peek();
	
	/**
		The equals method will compare a specified object with the queue to check for equality. This method implements the first-in-first-out stack
		
		@param  that
			Object used to compare the equality
		
		@return 
			Will return true if the object is equal to the element in thequeue
		
	*/

	public boolean equals(QueueADT<E> that);
	
	/**
		The iterator method will make a copy of every element of the queue and then place all of those elements into their respective place in the queue. After that the method will return iterator
		
		@return
			returns an iterator that covers over all the items that are contained within this stack
	*/

	public Iterator<E> iterator();
	
	/**
		The toArray method will return a array that contains all the objects that are contained within the queue, in the order that they appear within the queue.
		
		@return
			A array with all the objects in the queue
	*/

	public Object[] toArray();
	
	/**
		The toArray method will return a array that contains all the elements that are contained within the queue, in the order that they appear within the queue.
		
		@return
			A array with all the elements in the queue
	*/

	public E[] toArray(E[] copy);
	
	/**
		The isFull method will scan the queue to see if there is a element for each of its possible spaces. Will respond with a true or a false depending on the outcome. This method is meant for queues of fixed size.
		
		@return
			isFull will return True or False depending on the queue
	*/

	public boolean isFull();
	/**
		The size method will count total number of elements that are in the whole queue. With the queue counting from First-In-First-Out.
		
		@return
			size will return the number of elements in the whole queue
		well documented
	*/
	public int size();
	
	/**
		Fancy way of telling the program to clear the queue of all its elements
	*/

	public void dequeueAll();
}
