package UnionFind;

// Optimize Tree Height
public class UnionFindOptimizeRank implements UF{

    private int[] parent; 
    private int[] rank;     // rank[i]: the max depth of root i

    public UnionFindOptimizeRank(int size){

        parent = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i ++){
            parent[i] = i;
            rank[i] = 1;
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
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }
        else{ 
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
