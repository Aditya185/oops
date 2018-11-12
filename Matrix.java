 package lab_06;
import java.util.*;
public class Matrix {
    private  int M;             // number of rows
    private  int N;             // number of columns
    private  double[][] data;   // M*N array

    // create M*N matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;//any 2d array is of this type{{1,2,3},{4,5,6}}
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }
    // copy constructor
    private Matrix(Matrix A) { this(A.data); }
    
    // create and return the transpose of the matrix
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    public Matrix AddMatrix(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("IncompatibleSize");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    public Matrix MultiplyMatrix(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("IncompatibleSize");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }
    @Override
    public String toString() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) { 
                System.out.print(data[i][j]+" ");
        }
        System.out.println();
        }
        return "";
    }
    
    void set(int row, int col, double x) {
    	this.data[row][col]=x;	
    }
     double[][] get(int row, int col) {
    	 return this.data;
     }
     int getNumberOfRows() {
    	 return this.M;
     }
     int getNumberOfCols() {
    	 return this.N;
     }
}

