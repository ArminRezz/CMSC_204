import java.util.ArrayList;

/**
 * A stack implementation that stores elements of a generic type.
 * 
 * @author Armin Rezaiyan-Nojani  
 */

public class MyStack<T> implements StackInterface<T> {
	private T[] stack;
	private int top;
	private int maxSize;

	/**
	 * Constructs a new stack with a given maximum capacity.
	 * 
	 * @param size the maximum capacity of the stack
	 */
	public MyStack(int size) {
		this.maxSize = size;
		this.stack = (T[]) new Object[size];
		this.top = -1;
	}

	/**
	 * Constructs a new stack with a default maximum capacity of 10.
	 */
	public MyStack() {
		this(10);
	}

	/**
	 * Checks if the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Checks if the stack is full.
	 * 
	 * @return true if the stack is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return top == maxSize - 1;
	}

	/**
	 * Removes and returns the top element from the stack.
	 * 
	 * @return the top element of the stack
	 * @throws StackUnderflowException if the stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack[top--];
	}

	/**
	 * Returns the top element of the stack without removing it.
	 * 
	 * @return the top element of the stack
	 * @throws StackUnderflowException if the stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack[top];
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return top + 1;
	}

	/**
	 * Pushes an element onto the top of the stack.
	 * 
	 * @param e the element to be pushed onto the stack
	 * @return true if the element was successfully pushed, false otherwise
	 * @throws StackOverflowException if the stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		stack[++top] = e;
		return true;
	}

	/**
	 * Returns a string representation of the stack, with elements separated by a
	 * space character.
	 * 
	 * @return a string representation of the stack
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			sb.append(stack[i].toString());
		}
		return sb.toString();
	}

	/**
	 * Returns a string representation of the stack, with elements separated by a
	 * given delimiter.
	 * 
	 * @param delimiter the delimiter to be used to separate elements in the string
	 * @return a string representation of the stack
	 */
	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			sb.append(stack[i].toString());
			if (i != top) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	/**
	 * Adds all elements from the given list to the stack.
	 * 
	 * @param list the list of elements to add to the stack
	 * @throws StackOverflowException if the stack is already at maximum capacity 
	 */
	@Override
	public void fill(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			try {
				push(list.get(i));
			} catch (StackOverflowException e) {
				break;
			}
		}
	}

}