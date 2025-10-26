package priorityQueues8;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

/**
 * Generalises the idea of SORTing in a flexible data structure
 *
 *
 */

// Key is comparable meaning has a compareTo() method.
public class PriorityQueue<Key extends Comparable<Key>>{




    public static void main(String... args){
        // Ex. from lib course
        // binary heaps - N log M (M is the smaller constrained space of ALL of the stuff AKA N);
        MinPQ<Transaction> pq = new MinPQ<>();
        while(StdIn.hasNextLine()){
            String line = StdIn.readLine();
            Transaction item = new Transaction(line);
            pq.insert(item);
            if(pq.size() > 5) // M items constraints.
                pq.delMin();
        }

    }
}
