package Heap;

public class Main {
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(12);
        maxHeap.add(13);
        maxHeap.add(1);
        maxHeap.add(-2);
        maxHeap.add(99);
        maxHeap.add(44);
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
    }
}
