
/**
 * An implementation of the QueueInterface<T> interface using an array as the underlying data structure.
 * The queue is circular, allowing for efficient enqueue and dequeue operations.
 * @author Armin Rezaiyan-Nojani 
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private T[] elements;
	private int size;
	private int front;
	private int back;

	/**
	 * Constructs a new MyQueue with default capacity.
	 * 
	 * @return a new MyQueue with default capacity
	 */
	public MyQueue() {
		this(10);
	}

	/**
	 * Constructs a new MyQueue with specified capacity.
	 * 
	 * @param capacity the maximum number of elements the queue can hold
	 * @return a new MyQueue with specified capacity
	 */
	public MyQueue(int capacity) {
		elements = (T[]) new Object[capacity];
		size = 0;
		front = 0;
		back = 0;
	}

	/**
	 * Determines whether the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Determines whether the queue is full.
	 * 
	 * @return true if the queue is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return size == elements.length;
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * 
	 * @return the element at the front of the queue
	 * @throws QueueUnderflowException if the queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T data = elements[front];
		front = (front + 1) % elements.length;
		size--;
		return data;
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the back of the queue.
	 * 
	 * @param e the element to be added to the queue
	 * @return true if the element was successfully added, false otherwise
	 * @throws QueueOverflowException if the queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		elements[back] = e;
		back = (back + 1) % elements.length;
		size++;
		return true;
	}

	/**
	 * Returns a string representation of the queue, with elements separated by the
	 * specified delimiter.
	 * 
	 * @param delimiter the delimiter to use between elements
	 * @return a string representation of the queue
	 */
	@Override
	public String toString(String delimiter) {
		if (isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int index = front;
		for (int i = 0; i < size; i++) {
			result.append(elements[index]);
			if (i < size - 1) {
				result.append(delimiter);
			}
			index = (index + 1) % elements.length;
		}
		return result.toString();
	}

	@Override
	public void fill(ArrayList<T> list) {
		for (T e : list) {
			try {
				enqueue(e);
			} catch (QueueOverflowException exception) {
				break;
			}
		}
	}
}
