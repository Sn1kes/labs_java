public class LinkedStack<T> implements Stack<T> {

	private static class Node<T> {
		private T element;
		Node<T> next;
	}
	private Node<T> head;

	@Override
	public void push(T element) {
		if(head == null) {
			head = new Node<T>();
			head.element = element;
		} else {
			Node<T> cur = head;
			head = new Node<T>();
			head.element = element;
			head.next = cur;
		}
	}

	@Override
	public T pop() {
		if(head == null)
			throw new EmptyStackException();
		T element = head.element;
		head = head.next;
		return element;
	}

	@Override
	public int size() {
		int count = 0;
		while(head != null) {
			++count;
			head = head.next;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}
}
