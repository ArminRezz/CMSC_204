/**
 * A stack implementation that stores elements of a generic type.
 * 
 * @author Armin Rezaiyan-Nojani  
 */

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node head;
    protected Node tail;
    protected int size;

    /**
     * Creates an empty doubly linked list
     */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
    Adds a new element to the end of the list
    @param data the data to be added to the list
    */
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
    Adds a new element to the front of the list
    @param data the data to be added to the list
    */
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
    Returns the first element of the list
    @return the first element of the list, or null if the list is empty
    */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
    Returns the last element of the list
    @return the last element of the list, or null if the list is empty
    */
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    /**
    Returns the number of elements in the list
    @return the number of elements in the list
    */
    public int getSize() {
        return size;
    }

    /**
    Returns an iterator over the elements in the list
    @return an iterator over the elements in the list
    */
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
    Removes the first occurrence of a target element from the list
    @param targetData the data to be removed from the list
    @param comparator the comparator to be used to compare elements in the list
    @return the node that was removed from the list, or null if the element was not found
    */
    public Node remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current == head) {
                    return removeFirst();
                } else if (current == tail) {
                    return removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return current;
                }
            }
            current = current.next;
        }
        return null;
    }

    /**
    Removes and returns the first element of the list
    @return the first element of the list, or null if the list is empty
    */
    public T retrieveFirstElement() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        removeFirst();
        return data;
    }

    /**
    Removes and returns the last element of the list
    @return the last element of the list, or null if the list is empty
    */
    public T retrieveLastElement() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        removeLast();
        return data;
    }

    /**
    Converts the list to an ArrayList
    @return an ArrayList containing the elements of the list in order
    */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<T>(size);
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    /**
    Removes and returns the first element in the doubly linked list.
    @return the removed node, or null if the list is empty
    */
    protected Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node removedNode = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedNode;
    }

    /**
    Removes and returns the last element in the doubly linked list.
    @return the removed node, or null if the list is empty
    */
    protected Node removeLast() {
        if (tail == null) {
            return null;
        }
        Node removedNode = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedNode;
    }

    public class Node {
        protected T data;
        protected Node prev;
        protected Node next;

        protected Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
    An iterator for the doubly linked list.
    */
    protected class DoubleLinkedListIterator implements ListIterator<T> {
    	
        protected Node current;
        
        protected DoubleLinkedListIterator() {
            current = head;
        }

        /**
        Constructs a new iterator starting at the specified index.
        @param index the index to start the iterator at
        @throws IndexOutOfBoundsException if the index is out of range
        */
        protected DoubleLinkedListIterator(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            if (index == size) {
                current = null;
            } else {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return current != head;
        }

        @Override
        public T previous() throws NoSuchElementException {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No more elements");
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.prev;
            }
            return current.data;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T data) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T data) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
