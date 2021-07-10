package com.jetBrains;
import java.io.*;

public class CountingPaths1 {

    public static int getPaths(int n){
        if(n==0){
            return 1;
        }else if(n<3){
            return getPaths(n-1);
        }
        return getPaths(n-1) + getPaths(n-3);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(getPaths(n));
    }
}
