import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{
	
	private T[] queue;
	private int frontIndex;
	private int endIndex;
	private final int defaultSize = 50;
	private int capacity;
	
	/**
	 * Constructor that takes size
	 * @param size
	 * @author oherr
	 */
	@SuppressWarnings("unchecked")
	NotationQueue(int size){
		
		capacity = size;
		queue = (T[]) new Object[size];
		frontIndex = 0;
		endIndex = 0;
		
	}
	/**
	 * default constructor
	 * @author oherr
	 */
	
	@SuppressWarnings("unchecked")
	NotationQueue(){
		capacity = defaultSize;
		queue = (T[]) new Object[capacity];
		frontIndex = 0;
		endIndex = 0;
	}
	/**
	 *constructor takes array list as argument
	 * @param list
	 * @author oherr
	 */
	
	@SuppressWarnings("unchecked")
	
	NotationQueue(ArrayList<String> list){
		queue = (T[]) new Object[defaultSize];
		capacity = defaultSize;
		ArrayList<String> newList = new ArrayList<String>(list);
		newList.toArray(queue);
		frontIndex = 0;
		endIndex = newList.size();
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 * @author oherr
	 */

	@Override
	public boolean isEmpty() {
		return (endIndex == frontIndex);
	}
	
	/**
	 * Determines if the Queue is full
	 * @return true if queue i false 
	 * @author oherr
	 */

	@Override
	public boolean isFull() {
		return (capacity == endIndex);
	}
	
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @author oherr
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if(isEmpty()) 
			throw new QueueUnderflowException();
		else
		{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
		      frontIndex = (frontIndex + 1);
		      return front;
		}
		
		
			
	}
	

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 * @author oherr
	 */

	@Override
	public int size() {
		int counter = 0;
		for (int i = 0; i < capacity; i++)
		{
			if(queue[i] != null)
			{
				counter++;
			}
		}
		
		return counter;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 * @author oherr
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		else {
			queue[endIndex] =  e;
			endIndex++;
		}
		
		if (queue[endIndex - 1] != null)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 * @author oherr
	 */
	
	@Override
	public String toString(){
		String queueString = "";
		
		for (int i = 0; i < size(); i++)
		{
			queueString += queue[i];
		}
		
		return queueString;
		
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 * @author oherr
	 */
	@Override
	public String toString(String delimiter) {
		String queueString = "";
		for (int i = 0; i < size(); i++)
		{
			if (i+ 1 == size())
			{
				queueString += queue[i];
				break;
			}
			queueString += queue[i] + delimiter;
		}
		
		return queueString;
	}
	
	

}
