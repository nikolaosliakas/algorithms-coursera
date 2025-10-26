package mergeSort6;

public class Sort{

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // assert here that a is sorted
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // This is a systemArrayCopy - use native method and not this loop!
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        // increment for the number of elements in the array
        for (int k = lo; k <= hi; k++){
            // choose from which sub-array to copy
            // first two conditions are if either half has been exhausted
                // if the i pointer has passed mid or if the j pointer has passed the end.
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            // take from j's sub array if it is lesser
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            // else take from the left sub array (i's) if i is greater or equal.
            else                            a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);

    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        sort (a, aux, lo, mid);
        sort (a, aux, mid + 1, hi);
        // Improvement # 1 - essentially if the last element in the sorted first half is less than the first element in the sorted second half then you do not need to perform the merge operation (20% improvement)!
        if (!less(a[mid+1], a[mid])) return;

        // Improvement # 2 - switching is no actual copying needed:
        /*
        * sort (aux, a, lo, mid);
        * sort (aux, a,  mid + 1, hi);
        * merge(a, aux, lo, mid, hi); <--- this merge will change to not need to copy into aux since it is already written to!
        * */
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

}

