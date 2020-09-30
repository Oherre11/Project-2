import java.util.ArrayList;
import java.util.List;

public class NotationStack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int topIndex;
	private static final int defaultSize = 50;
	
	/**
	 * default constructor
	 * @author oherr
	 */
	@SuppressWarnings("unchecked")
	NotationStack(){
		stack = (T[]) new Object[defaultSize];
		topIndex = -1;
	}
	/**
	 * constructor takes int as size
	 * @param s
	 * @author oherr
	 */
	@SuppressWarnings("unchecked")
	NotationStack(int s){
		
		stack = (T[]) new Object[s];
		topIndex = -1;
	}
	/**
	 * constructor takes arraylist as size
	 * @param list
	 * @author oherr
	 */
	@SuppressWarnings("unchecked")
	NotationStack(ArrayList<String> list){
		
		stack = (T[]) new Object[defaultSize];
		ArrayList<String> newList = new ArrayList<String>(list);
		newList.toArray(stack);
		topIndex = newList.size() - 1;
		
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 * @author oherr
	 */
	@Override
	public boolean isEmpty() {
		
		return (topIndex == -1);		
		
	}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 * @author oherr
	 */

	@Override
	public boolean isFull() {
		if(topIndex == stack.length - 1)
			return true;
		else
			return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @author oherr
	 */
	@Override
	public T pop() throws StackUnderflowException{
		
		if (isEmpty())
		{
			throw new StackUnderflowException();
		}
		
		else {
		
			return stack[topIndex--];
		}
		
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @author oherr
	 */

	@Override
	public T top() throws StackUnderflowException {
		
		if (isFull() == true)
		{
			throw new StackUnderflowException();
		}
		
		else
		return stack[topIndex];
	}
	

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 * @author oherr
	 */
	@Override
	public int size() {
		return topIndex+1;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @author oherr
	 */
	
	@Override
	public boolean push(T e) throws StackOverflowException {
		
		if(isFull())
		{
			throw new StackOverflowException();
		}
		
		else 
		{
			stack[++topIndex] = e;
		}
		
		if (stack[topIndex] != null)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 * @author oherr
	 */
	@Override
	public String toString() {
		
		String stackString = "";
		
		for (int i = 0; i < size(); i++)
		{
			stackString += stack[i];
		}
		
		return stackString;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 * @author oherr
	 */
	
	@Override
	public String toString(String delimiter) {
		
		String stackString = "";
		
		for (int i = 0; i < size(); i++)
		{
			if (i+ 1 == size())
			{
				stackString += stack[i];
				break;
			}
			stackString += stack[i] + delimiter;
		}
		
		return stackString;
	}
	/**
	 * checks if the stack contains an element
	 * @param e
	 * @return true if element is found
	 * @author oherr
	 */
	public boolean contains(T e) {
		for (int i = 0; i < size(); i++)
		{
			if (stack[i] == e)
			{
				return true;
			}
		}
		
		return false;
	}
	
	
}

