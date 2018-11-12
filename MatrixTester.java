package lab_06;
import java.util.*;
public class MatrixTester {
     public static void main(String[] args) {
    	 Scanner in =new Scanner(System.in);
    	 System.out.println("please enter the no of rows:");
    	 int m = in .nextInt();
    	 System.out.println("please enter the no of columns:");
    	 int n = in .nextInt();
    	 double[][] op = new double[m][n];
    	 System.out.println("please enter the elements of matrix:");
    	 for(int i=0;i<m;i++) {
    		 for(int j=0;j<n;j++) {
    			 op[i][j]=in.nextInt();
    		 }
    	 }
    	 Matrix X = new Matrix(op);
    	 System.out.println("Your Matrix :");
    	 X.toString();
         System.out.println();
         System.out.println("After Transpose");
         Matrix Y = X.transpose();
         Y.toString(); 
         System.out.println();
         System.out.println("Addition of matrix and its transpose:");
         X.AddMatrix(Y).toString();
         System.out.println();
         System.out.println("Multiplication of matrix and its transpose:");
         X.MultiplyMatrix(Y).toString();
         System.out.println();
         X.set(0, 0, 5);
         System.out.println("After Setting the first Value to 5:");
         X.toString();
         System.out.println();
     }

}

