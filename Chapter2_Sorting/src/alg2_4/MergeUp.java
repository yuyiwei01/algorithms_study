package alg2_4;

import alg2_2.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class MergeUp {
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        if (hi - lo <= 15) {
            int i = 0;
            Comparable[] auxLow = new Comparable[hi - lo + 1];
            for (int k = lo; k <= hi; k++) {
                auxLow[i++] = a[k];
            }
            Insertion.sort(auxLow);
            i = 0;
            for (int k = lo; k <= hi; k++) {
                a[k] = auxLow[i++];
            }
        } else merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int k = 0;
        for (k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < 20; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
