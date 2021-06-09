import java.util.*;

public class CountInversion2 {

    public static int merge(int arr[], int l, int h, int m){
        int countInv = 0;
        int l1 = m-l+1;
        int l2 = h-m;
        int len = l1+l2;
        int arr1[] = new int[l1];
        int arr2[] = new int[l2];
        for(int i = 0 ; i<l1 ; i++){
            arr1[i] = arr[l+i];
        }
        for(int i = 0 ; i<l2 ; i++){
            arr2[i] = arr[m+1+i];
        }
        int k = l;
        int j = 0;
        int i = 0;
        while(i<l1 && j<l2){
            if(arr1[i]<arr2[j]){
                arr[k++] = arr1[i++];
            }else{
                arr[k++] = arr2[j++];
                countInv+=l1-i;
            }
        }
        while(i<l1){
            arr[k++] = arr1[i++];
        }
        while(j<l2){
            arr[k++] = arr2[j++];
        }
        return countInv;
    }

    public static int mergeSort(int arr[], int low, int high){
        int count = 0;
        if(low<high){
            int m = (low+high)/2;
            count += mergeSort(arr, low, m);
            count += mergeSort(arr, m+1, high);
            count += merge(arr, low, high, m);
        }
        return count;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int i = mergeSort(arr, 0, n-1);
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(s.charAt(i%26));
    }
}
