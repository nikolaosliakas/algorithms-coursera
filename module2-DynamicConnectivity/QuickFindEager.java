

public class QuickFindEager{
    private int[] id;
    /*
            0 1 2 3 4 5 6 7 8 9
    * id[]  0 1 1 8 8 0 0 1 8 8
    p and q are connected if they have the same id
    * */
    QuickFindEager(int N){
        id = new int[N];
        for(int i = 0; i <N; i++){
            id[i] = i;
        }
    }
    /**
     * Check if p and q have the same id
     * */
    private boolean connected(int p, int q){
        return id[p] == id[q];
    }
    /**
     * Merge components containing p and q
     * - Change all entries whose id = id[p] to id[q]
     * */
    private void union(int p, int q){
        // These are the integers representing the components!
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid)
                id[i] = qid;
        }
    }

}