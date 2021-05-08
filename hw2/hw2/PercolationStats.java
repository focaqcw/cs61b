package hw2;

public class PercolationStats {
    private int[] CntPercList;
    private int T;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        CntPercList =new int[T];
        this.T = T;
        for (int t = 0; t < T; t ++){
            Percolation SinglePerc = pf.make(N);
            int[] OpenList = edu.princeton.cs.algs4.StdRandom.permutation(N * N);
            for(int i = 0; i < N * N; i ++){
                SinglePerc.open(OpenList[i]/N, OpenList[i]%N);
                if(SinglePerc.percolates()){
                    CntPercList[t] = i + 1;
                    break;
                }
            }

        }



    }  // perform T independent experiments on an N-by-N grid
    public double mean(){
        return edu.princeton.cs.algs4.StdStats.mean(CntPercList);
    }                                           // sample mean of percolation threshold
    public double stddev(){
        return edu.princeton.cs.algs4.StdStats.stddev(CntPercList);
    }                                         // sample standard deviation of percolation threshold
    public double confidenceLow(){
        return mean() -1.96 * stddev()/java.lang.Math.sqrt(T);
    }                                  // low endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean() +1.96 * stddev()/java.lang.Math.sqrt(T);
    }                                 // high endpoint of 95% confidence interval

}
