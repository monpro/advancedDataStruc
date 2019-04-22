package LinkedList;

public class LinkedListQueue <E> implements Queue<E>{
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        Node resultNode = head;
        head = head.next;
        resultNode = null;
        if(head == null){
            tail = null;
        }
        size --;
        return resultNode.e;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("cannot get front of empty queue");
        }
        return head.e;
    }


}
