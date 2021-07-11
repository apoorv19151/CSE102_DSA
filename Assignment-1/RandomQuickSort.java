package com.jetBrains;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomQuickSort {

    static boolean compared;

    RandomQuickSort(){
        compared = false;
    }

    public static int getPivot(int arr[], int low, int high, int n1, int n2){
        int p = ThreadLocalRandom.current().nextInt(low, high);
        int temp = arr[p];
        arr[p] = arr[high-1];
        arr[high-1] = temp;
        p = high-1;
        int i = low-1;
        for(int j = low ; j<high ; j++){
            if((arr[j]==n1 && arr[p]==n2) || (arr[j]==n2 && arr[p]==n1)) compared = true;
            if(arr[j]<arr[p]){
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[p];
        arr[p] = arr[i+1];
        arr[i+1] = temp;
        return i+1;
    }

    public static void quickSortRandom(int arr[], int low, int high, int n1, int n2){
        if(low>=high) return;
        int p = getPivot(arr, low, high, n1, n2);
        quickSortRandom(arr, low, p, n1, n2);
        quickSortRandom(arr, p+1, high, n1, n2);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if(n==0) return;
        String s1[] = reader.readLine().split(" ");
        int arrSorted[] = new int[n];
        int arrUnsorted[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arrSorted[i] = Integer.parseInt(s1[i]);
            arrUnsorted[i] = Integer.parseInt(s1[i]);
        }
        String s2[] = reader.readLine().split(" ");
        int i = Integer.parseInt(s2[0]);
        int j = Integer.parseInt(s2[1]);
        quickSortRandom(arrSorted, 0, n, 0, 0);
        int n1 = arrSorted[i];
        int n2 = arrSorted[j];
        double p = 0;
        for(int k = 1 ; k<=1000000 ; k++){
            RandomQuickSort obj = new RandomQuickSort();
            RandomQuickSort.quickSortRandom(arrUnsorted, 0, n, n1, n2);
            if(RandomQuickSort.compared){
                p++;
            }
        }
        double probability = p/(double)1000000;
        System.out.println(probability);
    }
}
