package SegmentTree;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);

    }

    //create segTree for[left...right] at treeIndex
    private void buildSegmentTree(int treeIndex, int left, int right){
        if(left == right){
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid =  left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex,left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    //return value of [queryLeft, queryRight]
    public E query(int queryLeft, int queryRight){
        if(queryLeft < 0 || queryLeft >= data.length
                || queryRight < 0 || queryRight >= data.length || queryLeft > queryRight){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0,0,data.length - 1, queryLeft, queryRight);
    }
    //
    private E query(int treeIndex, int left, int right, int queryL, int queryR){
        if(left == queryL && right == queryR){
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL >= mid + 1){
            return query(rightTreeIndex, mid + 1, right, queryL, queryR);
        }
        else if(queryR <= mid){
            return query(leftTreeIndex, left, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, left, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, right, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }

    public void set(int index, E e){
        if( index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = leftChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);
        
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public int getSize(){
        return data.length;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for(int i = 0; i < tree.length; i++){
            if(tree[i] != null)
                result.append(tree[i]);
            else
                result.append("null");
            if(i != tree.length - 1)
                result.append(",");
        }
        result.append(']');
        return result.toString();

    }
}
