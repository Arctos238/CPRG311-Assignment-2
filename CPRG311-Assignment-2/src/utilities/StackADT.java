package utilities;

public interface StackADT<E> {

	/**
		Appends the specified element on top of the stack. Once we create a stack stance, we can use the push operation to add the elements of the stack object type to the stack. 
		
		@param toAdd
			A type E object to be appended on the top of the list
		@return
			The method returns the argument being pushed as a parameter.
	*/
	public void push(E toAdd);

	/*
		Removes an object at the top of the stack. This method throws an EmptyStackException when the invoking stack is empty.
		
		@return the object being that is being removed
	*/
	public E pop();

	/*
		Prints the element on top of the stack without removing it. This also throws an EmptyStackException when invoking stack is empty.
		
		@return The element on top of the stack.
	*/
	public E peek();

	/*
		This method verifies the equality of an Object with a stack and compare them. This stack is inherited from the Vector class which implements the last-ihn, first-out stack.
		@param that
			The object to be compared to the first object or stack.
		@return true if both objects are equal, else it will return false
	*/
	public boolean equals(StackADT<E> that);

	/*
		Returns an iterator of the same elements as that of the Stack. In the returned iterator, the elements are returned from index 0 (From the first one pushed to the last).	
		
		@return an iterator over the elements in the list in proper sequence
	*/
	public Iterator<E> iterator();

	/*
		This method forms an array with the same element as of the Stack in the correct order. The values of the array will be what is inside the stack. The first object pushed in the stack will be the first element in the array.
		
		@return an array containing the elements similar to the Stack.
	*/
	public Object[] toArray();

	/*
		This method forms an array of the same elements as that of the Stack in the correct order. If the Stack is larger than the Object array to be made, the array size will be adjusted depending on the converted object to array. If the Stack is equal to the Object array to be made, the Stack will be returned as is converted to an array. If the Object array to be made is larger than the Stack to be converted, the excess indexes will equal to null
		
		@param copy
			The method accepts one E[] array type object which is the array into which the elements of the Stack are to be stored.
		@return an array containing the elements similar to the Stack.
	*/
	public E[] toArray(E[] copy);

	/*
		This method searches for the parameter object from the Stack. It getts the distance from the top of the stack starting from the position 1 being what is the top of the stack. If more than one is found, the index of the element closer to the top is returned. The method returns the position of the searched object if the element is successful. If it's not successful, it will return -1.
		
		@param The method accepts one parameter element which refers to the element to be searched for in the Stack.
		@return The position of the element from the stack if the search is successful. If not, it will return -1.
	*/
	public int search(E obj);

	/*
		This method is used to check if a specific element is in the Stack or not.
		
		@param obj
			an E type object that is a mandatory parameter. This is the element that is tested if it exists in the stack or not.	
		@return true if the element exists in the Stack, false if it does not exist in the Stack.
	*/
	public boolean contains(E obj);

	/*
		This method is used to get the size of the stack or to get the number of elements that is in the Stack.
		
		@return the size or number of elements present in the stack.
	*/
	public int size();

	/*
		This method checks if the stack is empty or not
		
		@return true if the stack has elements, false if the stack is empty
	*/
	public boolean isEmpty();

	/*
		This method is used to remove all the elements in the Stack. Using this only removes the elements from the Stack but does not delete the Stack itself. In conclusion, this stack is used to remove elements from existing Stack.
	*/
	public void clear();
}
