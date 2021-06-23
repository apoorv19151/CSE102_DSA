import java.util.Scanner;

public class SortTheStudents2 {

    public static long merge(int arr[], int l, int h, int m){
        long efforts = 0;
        int l1 = m-l+1;
        int l2 = h-m;
        int len = l1+l2;
        int arr1[] = new int[l1];
        int arr2[] = new int[l2];
        int sum = 0;
        for(int i = 0 ; i<l1 ; i++){
            arr1[i] = arr[l+i];
            sum += arr1[i];
        }
        for(int i = 0 ; i<l2 ; i++){
            arr2[i] = arr[m+1+i];
        }
        int k = l;
        int j = 0;
        int i = 0;
        while(i<l1 && j<l2){
            if(arr1[i]<arr2[j]){
                arr[k] = arr1[i];
                sum -= arr1[i];
                k++;
                i++;
            }else if(arr2[j]<arr1[i]){
                arr[k] = arr2[j];
                efforts += sum;
                k++;
                j++;
            }else{
                arr[k] = arr1[i];
                sum -= arr1[i];
                k++;
                i++;
            }
        }
        while(i<l1){
            arr[k++] = arr1[i++];
        }
        while(j<l2){
            arr[k++] = arr2[j++];
        }
        return efforts;
    }

    public static long mergeSort(int arr[], int low, int high){
        long efforts = 0;
        if(low<high){
            int m = (low+high)/2;
            efforts += mergeSort(arr, low, m);
            efforts += mergeSort(arr, m+1, high);
            efforts += merge(arr, low, high, m);
        }
        return efforts;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mergeSort(arr, 0, arr.length-1));
    }
}
