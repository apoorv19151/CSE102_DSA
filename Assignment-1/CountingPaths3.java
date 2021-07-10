package com.jetBrains;
import java.io.*;

public class CountingPaths3 {

    public static long[][] multiplyMatrix(long a[][], long b[][]){
        long m = 1000000000+7;
        int rows = a.length;
        int cols = b[0].length;
        long res[][] = new long[rows][cols];
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<cols ; j++){
                for(int k = 0 ; k<a[0].length ; k++){
                    long sum = ((a[i][k]%m)*(b[k][j]%m))%m;
                    res[i][j] = ((res[i][j]%m) + (sum%m))%m;
                }
            }
        }
        return res;
    }

    public static long[][] exponentMatrix(long a[][], int m){
        int n = a.length; // Assuming a is a square matrix of size n x n.
        long I[][] = new long[n][n];
        for(int i = 0 ; i<n ; i++){
            I[i][i] = 1;
        }
        if(m==0) return I;
        else if(m%2==0){
            long X[][] = exponentMatrix(a, m/2);
            return multiplyMatrix(X, X);
        }else return multiplyMatrix(a, exponentMatrix(a, m-1));
    }

    public static long getFastPath(int n){
        if(n<=2) return 1;
        if(n==3) return 2;
        long matrix1[][] = {{1, 0, 1}, {1, 0, 0}, {0, 1, 0}};
        long matrix2[][] = {{2}, {1}, {1}};
        long res[][] = multiplyMatrix(exponentMatrix(matrix1, n-3), matrix2);
        return res[0][0];
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(getFastPath(n));
    }
}
