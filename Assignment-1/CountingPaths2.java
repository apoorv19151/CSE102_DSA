package com.jetBrains;
import java.io.*;

public class CountingPaths2 {

    public static long getPaths2(int n){
        if(n<=2) return 1;
        if(n==3) return 2;
        long n1 = 1, n2 = 1, n3 = 2;
        long m = 1000000000+7;
        for(int i = 4 ; i<=n ; i++){
            long cur = ((n3%m)+(n1%m))%m;
            n1 = n2%m;
            n2 = n3%m;
            n3 = cur;
        }
        return n3;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(getPaths2(n));
//        for(int i = 1 ; i<=50 ; i++){
//            System.out.println(i+" "+getPaths2(i));
//        }
    }
}
