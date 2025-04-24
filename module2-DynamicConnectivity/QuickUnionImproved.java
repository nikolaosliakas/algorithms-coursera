
class QuickUnionImproved{

    private int[] id;
    private int[] sz;

    ///Weighted Quick Union
    ///- modify quickunion to avoid tall trees.
    /// - keep track of size of tree (number of obj)
    /// - Balance by linkin root of similar small tree to large tree
    /// - The smaller tree always goes below!
    QuickUnionImproved(int N){
        id = new int[N];
        for(int i = 0; i <N; i++) id[i] = i;
    }
    private int root(int i){
        // go through every i
        while(i != id[i]) i = id[i];

        return i;
    }

    /// call root of p and q to then test equivalence
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if(i == j) return;
        if(sz[i] < sz[j]) {
            // Change the root of p id[i] value to the root of q j
            id[i] = j;
            // increment the size array for j by adding the size of i's array
            sz[j] += sz[i];
        } else{
        // do the opposite
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}