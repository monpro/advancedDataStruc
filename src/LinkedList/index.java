package LinkedList;

public class index {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        for(int i = 0 ; i < 10; i++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
