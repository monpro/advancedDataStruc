package UnionFind;

public class UnionFindTree implements UF {

    private int[] parent;

    // 构造函数
    public UnionFindTree(int size){

        parent = new int[size];

        for( int i = 0 ; i < size ; i ++ )
            parent[i] = i;
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    // O(h)
    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        // parent[p] == p if root node
        while(p != parent[p])
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

        if( pRoot == qRoot )
            return;

        parent[pRoot] = qRoot;
    }
}