package test02;

import alg2_1.Selection;
import alg2_2.Insertion;
import alg2_3.Shell;
import alg2_4.Merge;
import alg2_4.MergeBU;
import alg2_4.MergeUp;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "Insertion" :
                Insertion.sort(a);
            case "Selection" :
                Selection.sort(a);
            case "Shell" :
                Shell.sort(a);
            case "Merge" :
                Merge.sort(a);
            case "MergeUp" :
                MergeUp.sort(a);
            case "MergeBU" :
                MergeBU.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(1,10000000);
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 5000;
        int T = 3000;
        double[] time = new double[10];
        String[] alg = new String[]{
//                "Insertion",
//                "Selection",
//                "Shell",
                "Merge",
//                "MergeUp",
                "MergeBU"
        };
        for (int i = 0; i < alg.length; i++){
            time[i] = timeRandomInput(alg[i], N, T);
            StdOut.println("算法" + alg[i] + "运行总时间为" + time[i]);
            if (i > 0) {
                if (time[i] < time[i-1])
                    StdOut.println(alg[i]
                            + "算法比"
                            + alg[i-1]
                            + "算法快"
                            + String.format("%.2f", ((time[i-1] - time[i])/time[i-1])*100) + "%"
                    );
                if (time[i] > time[i-1])
                    StdOut.println(alg[i-1]
                            + "算法比"
                            + alg[i]
                            + "算法快"
                            + String.format("%.2f", ((time[i] - time[i-1])/time[i])*100) + "%"
                    );
            }
        }
    }
}
