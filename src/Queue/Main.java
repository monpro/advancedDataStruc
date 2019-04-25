package Queue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int opCount = 50000;
        ArrayQueue arrayQueue = new ArrayQueue();
        double time_1 = testQueue(arrayQueue,opCount);
        System.out.println(String.format("Array Queue will consume time: %f\n",time_1));
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time_2 = testQueue(loopQueue, opCount);

        System.out.println(String.format("Loop Queue will consume time : %f\n",time_2));
    }

    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < opCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i < opCount; i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
