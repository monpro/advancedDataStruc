package SegmentTree;

public class Main {
    public static void main(String[] args){
        Integer[] nums = {-2, 0, 3, 12, 7, -9};

        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, (a,b)-> a + b);

        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0,2));
    }
}
