package LinkedList;


public class LinkedListStack<E> implements Stack<E> {

    LinkedList linkedList;

    public LinkedListStack(LinkedList linkedList) {
        this.linkedList = new LinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return (E) linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return (E) linkedList.getFirst();
    }
}
