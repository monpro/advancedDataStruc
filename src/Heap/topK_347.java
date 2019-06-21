package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class topK_347 {


     private class Freq implements Comparable<Freq>{
        int value;
        int freq;

         public Freq(int value, int freq) {
             this.value = value;
             this.freq = freq;
         }

         @Override
        public int compareTo(Freq anotherFreq) {
            if(this.freq < anotherFreq.freq){
                return 1;
            }
            else if(this.freq == anotherFreq.freq){
                return 0;
            }
            else {
                return -1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else{
                map.put(i,1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<Freq>();
        for(int key: map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(new Freq(key, map.get(key)));
            }
            else if(map.get(key) > priorityQueue.peek().freq){
                priorityQueue.poll();
                priorityQueue.add(new Freq(key, map.get(key)));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.poll().value);
        }
        return result;
    }
}
