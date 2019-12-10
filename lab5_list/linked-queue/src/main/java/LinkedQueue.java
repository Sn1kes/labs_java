/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {

    private static class Node<T> {
        private T element;
        Node<T> next;
    }
    private Node<T> head;
    private Node<T> tail;
    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if(head == null) {
            head = new Node<T>();
            tail = head;
        } else {
            tail.next = new Node<T>();
            tail = tail.next;
        }
        tail.element = element;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if(head == null)
            return null;
        T element = head.element;
        if(head.next != null)
            head = head.next;
        else
            head = null;
        return element;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        int count = 0;
        Node<T> iter = head;
        while(iter != null) {
            ++count;
            iter = iter.next;
        }
        return count;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return head == null;
    }
}
