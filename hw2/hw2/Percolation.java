package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int N;
    private WeightedQuickUnionUF connector;


    public Percolation(int N) {    // create N-by-N grid, with all sites initially blocked
        this.N = N;
        connector = new WeightedQuickUnionUF(N * N);
        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
    }

    private int xyTo1D(int r, int c) {
        return r * N + c;
    }

    public void open(int row, int col){   // open the site (row, col) if it is not open already
        grid[row][col] = true;

        if (row != 0){
            if (grid[row - 1][col]) {
                connector.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            }
        }
        if (row != N - 1){
            if (grid[row + 1][col]) {
                connector.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            }
        }
        if (col != 0 ){
            if (grid[row][col - 1]) {
                connector.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            }
        }
        if (col != N - 1){
            if( grid[row][col + 1]) {
                connector.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            }
        }

    }
    public boolean isOpen(int row, int col){  // is the site (row, col) open?
        return grid[row][col];
    }
    public boolean isFull(int row, int col){
        for(int i = 0; i < N; i++){
            if (connector.find(i) == connector.find(xyTo1D(row,col))
                & isOpen(row, col)){
                return true;
            }
        }
        return false;

    }  // is the site (row, col) full?
    public int numberOfOpenSites(){
        int cnt = 0;
        for (int i= 0; i < N*N; i ++){
            if(grid[i/N][i % N]){
                cnt += 1;
            }
        }
        return cnt;
    }           // number of open sites
    public boolean percolates(){
        for (int i = 0; i < N; i ++){
            if (isFull(N-1,i)){
                return true;
            }
        }
        return false;
    }              // does the system percolate?
//        public static void main(String[] args){
//            return;
//        }   // use for unit testing (not required)

}
