import java.io.*;
import java.util.*;

public class SortTheStudents {

    public static int getEffort(int arr[]){
        int n = arr.length;
        int e = 0;
        for(int i = 1 ; i<n ; i++){
            int j = i-1;
            int temp = arr[i];
            while(j >= 0 && arr[j]>temp){
                e += arr[j];
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return e;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getEffort(arr));
    }
}
