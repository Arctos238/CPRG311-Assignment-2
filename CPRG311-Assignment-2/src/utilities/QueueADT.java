package utilities;

public interface QueueADT<E> {
	
	/**  
		The enqueue method will add one specified element to the end of a queue of elements. We can use to push operation to add the element to the end of the queue of elements.
		Precondition: A specified value will be supplied
		Postcondition: If a value was specififed and there is not a restriction to the size of the queue, or some other restriction then the value will be added to the end of the queue
		
		@exception NullPointerException
		@param toAdd
			A type E object that will be added to the end of the sequenece 
		@return
			This method will return a argument that will be pushed as a perameter
	*/

	public void enqueue(E toAdd);
	/**
		The dequeue method will remove the first element of the queue. This function will throw NoSuchElementException  when the queue has no elements within the queue
		Precondition: The queue length is greater than 0
		Postcondtition:  If the queue is longer than 0, the first element within the queue will be removed, that element will be replaced by the next element within the queue
		
		@exception IndexOutOfBoundsException
		@return
			This method will return the element that has been removed
	
	*/

	public E dequeue();
	/**
		The peek method will view the first element of the queue without the programming having to remove the element afterwards. Will return null if the queue is empty
		Precondition: The queue length is greater than 0
		Postcondition: If the queue is longer than 0, the first element of the queue will be displayed for the user
		
		@exception IndexOutOfBoundsException
		@return
			This method will return the first element of the queue
		
	*/

	public E peek();
	
	/**
		The equals method will compare a specified object with a specified element within the queue to check for equality. This method implements the first-in-first-out stack
		Precondition: A vaild number is provied that can be used to compare against the queue
		Postcondition: If the value that has been specified is equal to the element within the queue, then the method will return a true, and will return falsse otherwise
		
		@exception NullPointerException
		@param  that
			Object used to compare the equality
		
		@return 
			Will return true if the object is equal to the element in the queue
		
	*/

	public boolean equals(QueueADT<E> that);
	
	/**
		The iterator method will make a copy of every element of the queue and then place all of those elements into their respective place in the queue. After that the method will return iterator
		Precondition: A queue with a length grater than 0
		Postcondition: If the queue was gretaer than 0 then a iterator will be returned with all the of elements within the array within it
		
		@exception IndexOutOfBoundsException
		@return
			returns an iterator that covers over all the items that are contained within this stack
	*/

	public Iterator<E> iterator();
	
	/**
		The toArray method will return a array that contains all the objects that are contained within the queue, in the order that they appear within the queue.
		Precondition: A queue with a length grater than 0
		Postcondition: If the length of the queue was greater than 0, toArray will be returned with all of the objects of the queue within it
		
		@exception IndexOutOfBoundsException
		@return
			A array with all the objects in the queue
	*/

	public Object[] toArray();
	
	/**
		The toArray method will return a array that contains all the elements that are contained within the queue, in the order that they appear within the queue.
		Precondition: A queue with a length grater than 0
		Postcondition: If the length of the queue was greater than 0, toArray will be returned with all of the elements of the queue within it
		
		@exception IndexOutOfBoundsException
		@return
			A array with all the elements in the queue
	*/

	public E[] toArray(E[] copy);
	
	/**
		The isFull method will scan the queue to see if there is a element for each of its possible spaces. Will respond with a true or a false depending on the outcome. This method is meant for queues of fixed size.
		Precondition: The queue that is being tested must have a limit on how long it is allowed to. Aswell as a specified number of available spots in the queue
		Postcondition: If there is a limit on the legnth of the queue, true will be returned if the number of elements within the queue is equal to the number of 
		spots specifed, will return false if the number of elements is less than the specified number
		
		@exception IndexOutOfBoundsException
		@exception NullPointerException
		@return
			isFull will return True or False depending on the queue
	*/

	public boolean isFull();
	/**
		The size method will count total number of elements that are in the whole queue. With the queue counting from First-In-First-Out.
		Precondition: Must have a queue that is longer than 0
		Postcondition: If the queue is greater than 0, size will return the total number of elements held within the queue
		
		@exception IndexOutOfBoundsException
		@return
			size will return the number of elements in the whole queue
		well documented
	*/
	public int size();
	
	/**
		The dequeueAll method clears the queue of all its elements inside the data structure.
		Precondition: Must have a queue that is longer than 0
		Postcondition: If the queue is greater than 0, dequeueAll will remove all of the elements that are held within the queue
		
		@exception IndexOutOfBoundsException
	*/

	public void dequeueAll();
}
