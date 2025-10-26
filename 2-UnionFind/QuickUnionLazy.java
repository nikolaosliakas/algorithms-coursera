public class QuickUnionLazy {
    private int[] id;

    /*
     * Interpretation: id[i] is parent of i - a forest
     * Root of i is id[id[id[...id[i]...]]]
     *
     *       0 1 2 3 4 5 6 7 8 9
     * id[]  0 1 9 4 9 6 6 7 8 9
     *      0   1   9       6   7   8
     *            /   \     |
     *            2   4     5
     *                |
     *                3
     * Root of 3 is 9!
     * Find: check if p and q have the same root
     * Union: merge components containing p and q by seting id of p's root to the id of qs root.
     * Only one value needs to change to merge 6 and 9 (trees that start with root)
     *  So if p were 3 and q was 5. The contents at index 9 would change from 9 -> 6
     *       0 1 2 3 4 5 6 7 8   9
     * id[]  0 1 9 4 9 6 6 7 8 //6//
     * */
    QuickUnionLazy(int N){
        id = new int[N];
        for(int i = 0; i <N; i++){
            id[i] = i;
        }
    }

    ///  Find i's root
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
        // Still need to find the root so N array accesses
        int i = root(p);
        int j = root(q);

        id[i] = j;
    }


}
