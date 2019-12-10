import java.lang.*;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

    private static class Node<T> {
        private T element;
        Node<T> next;
    }
    private Node<T> head;
    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        List<T> list = new LinkedList<>();
        for(T elem : elements) {
            list.add(elem);
        }
        return list;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if(head == null) {
            head = new Node<T>();
            head.element = element;
            return;
        }
        Node<T> iter = head;
        while(iter.next != null) {
            iter = iter.next;
        }
        iter.next = new Node<T>();
        iter.next.element = element;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iter = head;
        for(int i = 0; i < index - 1; ++i) {
            iter = iter.next;
            if(iter == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if(index == 0) {
            head = new Node<T>();
            head.element = element;
            head.next = iter;
        } else {
            Node<T> next = iter.next;
            iter.next = new Node<T>();
            iter.next.next = next;
            iter.next.element = element;
        }
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if(head == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iter = head;
        for(int i = 0; i < index; ++i) {
            iter = iter.next;
            if(iter == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        iter.element = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if(head == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iter = head;
        for(int i = 0; i < index; ++i) {
            iter = iter.next;
            if(iter == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return iter.element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if(head == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iter = head;
        for(int i = 0; i < index - 1; ++i) {
            iter = iter.next;
            if(iter == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if(iter.next == null) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            head = head.next;
        } else {
            iter.next = iter.next.next;
        }
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> iter = head;
        while(iter != null) {
            if(iter.element == element)
                return true;
            iter = iter.next;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
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
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
    }
}
