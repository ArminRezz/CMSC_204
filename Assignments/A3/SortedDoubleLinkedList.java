import java.util.Comparator;

/**
 * 
 * This class represents a sorted double linked list which extends
 * BasicDoubleLinkedList.
 * 
 * The order of the elements in the list is determined by the comparator
 * provided when the list is created.
 * 
 * @param <T> the type of elements stored in the list
 * @author Armin Rezaiyan-Nojani
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private final Comparator<T> comparator;

	/**
	 * 
	 * Constructs a sorted double linked list using the provided comparator to
	 * determine how the list is to be sorted.
	 * 
	 * @param comparator the comparator to use to sort the list
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * 
	 * Inserts the specified element into the list in sorted order using the
	 * provided comparator.
	 * 
	 * @param data the element to insert
	 */
	public void add(T data) {
		Node newNode = new Node(data);
		if (head == null && tail == null) {
			head = tail = newNode;
		} else {
			Node current = head;
			while (current != null && comparator.compare(data, current.data) > 0) {
				current = current.next;
			}
			if (current == null) {
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			} else {
				newNode.prev = current.prev;
				newNode.next = current;
				if (current == head) {
					head = newNode;
				} else {
					current.prev.next = newNode;
				}
				current.prev = newNode;
			}
		}
		size++;
	}

	/**
	 * 
	 * This operation is not supported for a sorted list and throws an
	 * UnsupportedOperationException.
	 * 
	 * @param data the element to add to the end of the list
	 * @throws UnsupportedOperationException always thrown for a sorted list
	 */
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	/**
	 * 
	 * This operation is not supported for a sorted list and throws an
	 * UnsupportedOperationException.
	 * 
	 * @param data the element to add to the front of the list
	 * @throws UnsupportedOperationException always thrown for a sorted list
	 */
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
}