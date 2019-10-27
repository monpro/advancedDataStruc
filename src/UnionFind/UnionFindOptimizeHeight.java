package UnionFind;

// Optimize Tree Height
public class UnionFindOptimizeHeight implements UF{

    private int[] parent; 
    private int[] nodeNumber;     // nodeNumber[i]: number of nodes of root i

    public UnionFindOptimizeHeight(int size){

        parent = new int[size];
        nodeNumber = new int[size];

        for(int i = 0 ; i < size ; i ++){
            parent[i] = i;
            nodeNumber[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    // O(h)
    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while( p != parent[p] )
            parent[p] = parent[parent[p]];
            p = parent[p];
        return p;
    }

    // O(h)
    @Override
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    // O(h)
    @Override
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        // merge according the number of nodes
        // merge less to more
        if(nodeNumber[pRoot] < nodeNumber[qRoot]){
            parent[pRoot] = qRoot;
            nodeNumber[qRoot] += nodeNumber[pRoot];
        }
        else{ 
            parent[qRoot] = pRoot;
            nodeNumber[pRoot] += nodeNumber[qRoot];
        }
    }
}
