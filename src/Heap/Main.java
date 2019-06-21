package Heap;

import java.util.Random;

public class Main {

    public static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        if(isHeapify){
            MaxHeap maxHeap = new MaxHeap(testData);
        }
        else{
            MaxHeap maxHeap = new MaxHeap();
            for(int i : testData){
                maxHeap.add(i);
            }
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 100000000.0;
    }

    public static void main(String[] args){
        int n = 100000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0; i < n; i++){
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double withHeapifyTime = testHeap(testData, true);

//        double withoutHeapifyTime = testHeap(testData, false);

        System.out.println(withHeapifyTime);

//        System.out.println(withoutHeapifyTime);



    }
}
