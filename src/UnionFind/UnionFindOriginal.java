package UnionFind;

public class UnionFindOriginal implements UF {

    private int[] id;    // is an array

    public UnionFindOriginal(int size) {

        id = new int[size];

        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    @Override
    public int getSize(){
        return id.length;
    }

    // O(1)
    private int find(int p) {
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");

        return id[p];
    }

    // O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // O(n)
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
    }
}