package utilities;

public interface StackADT<E> {

	/**
		Appends the specified element on top of the stack. Once we create a stack stance, we can use the push operation to add the elements of the stack object type to the stack. 
		Pre-condition: A specific object of the E type will be given
		Post-condition: If the entry was found successful, the specified object will be added on top of the stack
		
		@param toAdd
			A type E object to be appended on the top of the list
		@return
			The method returns the argument being pushed as a parameter.
	*/
	public void push(E toAdd);

	/*
		Removes an object at the top of the stack. This method throws an EmptyStackException when the invoking stack is empty.
		Pre-condition: An object is selected from the stack
		Post-condition: If the stack is found, the selected object will be removed from the Stack
		
		@return the object being that is being removed
		@throws EmptyStackException when an object is being removed while the Stack is already empty
	*/
	public E pop() throws EmptyStackException;

	/*
		Prints the element on top of the stack without removing it. This also throws an EmptyStackException when invoking stack is empty.
		Pre-condition: There is at least one object in the stack
		Post-condition: If successful, the object on top of the stack will be printed or if executed and the stack is empty, an EmptyStackException will be thrown
		
		@return The element on top of the stack.
		@return the object being that is being removed
		@throws EmptyStackException when an object is executed to be printed while the Stack is already empty
	*/
	public E peek() throws EmptyStackException;

	/*
		This method verifies the equality of an Object with a stack and compare them. This stack is inherited from the Vector class which implements the last-in, first-out stack.
		Pre-condition: Two objects of the same type are compared
		Post-condition: If both objects are equal, true will be returned and false if not
		
		@param that
			The object to be compared to the first object or stack.
		@return true if both objects are equal, else it will return false
	*/
	public boolean equals(StackADT<E> that);

	/*
		Returns an iterator of the same elements as that of the Stack. In the returned iterator, the elements are returned from index 0 (From the first one pushed to the last).
		Pre-condition: A stack will be given
		Post-condition:	The stack will be iterated and returned in proper sequence (from the first one pushed to the last)
		
		@return an iterator over the elements in the list in proper sequence
	*/
	public Iterator<E> iterator();

	/*
		This method forms an array with the same element as of the Stack in the correct order. The values of the array will be what is inside the stack. The first object pushed in the stack will be the first element in the array.
		Pre-condition: A stack is given
		Post-condition: An array type of the stack will be returned if there are no exceptions. The array will contain the same objects in the stack in the order of which object was pushed first
		
		@return an array containing the elements similar to the Stack.
		@throws ArrayStoreException if the runtime type is not a supertype of the runtime type of every element
		@throws NullPointerException if the given array is null or empty
	*/
	public Object[] toArray() throws ArrayStoreException, NullPointerException;

	/*
		This method forms an array of the same elements as that of the Stack in the correct order. If the Stack is larger than the Object array to be made, the array size will be adjusted depending on the converted object to array. If the Stack is equal to the Object array to be made, the Stack will be returned as is converted to an array. If the Object array to be made is larger than the Stack to be converted, the excess indexes will equal to null.
		Pre-condition: An array that is larger than the object array is given
		Post-condition: This will return an array from the other of which Object was pushed first and the empty extra indexes will have null values
		
		@param copy
			The method accepts one E[] array type object which is the array into which the elements of the Stack are to be stored.
		@return an array containing the elements similar to the Stack.
		@throws ArrayStoreException if the runtime type of 'a' is not a supertype of the runtime type of every element
		@throws NullPointerException if the given array is null or empty
	*/
	public E[] toArray(E[] copy) throws ArrayStoreException, NullPointerException;

	/*
		This method searches for the parameter object from the Stack. It getts the distance from the top of the stack starting from the position 1 being what is the top of the stack. If more than one is found, the index of the element closer to the top is returned. The method returns the position of the searched object if the element is successful. If it's not successful, it will return -1.
		Pre-condition: An object from a stack is given
		Post-condition: If the element is found and there are more than one of the same type, the closest one to the top will be returned. If there's only one element found, it will return its position and if it is not found, it will return -1.
		
		@param The method accepts one parameter element which refers to the element to be searched for in the Stack.
		@return The position of the element from the stack if the search is successful. If not, it will return -1.
	*/
	public int search(E obj);

	/*
		This method is used to check if a specific element is in the Stack or not.
		Pre-condition: An object in a stack is given
		Post-condition: If the said element is found, it will return true and returns false if it is not found in the stack
		
		@param obj
			an E type object that is a mandatory parameter. This is the element that is tested if it exists in the stack or not.	
		@return true if the element exists in the Stack, false if it does not exist in the Stack.
	*/
	public boolean contains(E obj);

	/*
		This method is used to get the size of the stack or to get the number of elements that is in the Stack.
		Pre-condition: A stack is given
		Post-condition: This will return the size of the stack
		
		
		@return the size or number of elements present in the stack.
	*/
	public int size();

	/*
		This method checks if the stack is empty or not
		Pre-condition: A stack is selected
		Post-condition: If the stack has elements, it will return true. If the stack is empty, it will return false.
		
		
		@return true if the stack has elements, false if the stack is empty
	*/
	public boolean isEmpty();

	/*
		This method is used to remove all the elements in the Stack. Using this only removes the elements from the Stack but does not delete the Stack itself. In conclusion, this stack is used to remove elements from existing Stack.
		Pre-condition: A stack with elements is selected
		Post-condition: All the elements in the selected stack will be removed
	*/
	public void clear();
}
