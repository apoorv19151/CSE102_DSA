import java.util.Scanner;

public class TutorialAttendanceDrama {

    public static boolean works(int arr[], int X, int size){
        int n = 1; // no of tutorial groups
        int a = 0; // attendance
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] > size){
                return false;
            }else if((a+arr[i]) <= size){
                a += arr[i];
            }else if((a + arr[i]) > size){
                n++;
                a = 0;
                a += arr[i];
            }
            if(n > X){
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int low, int high, int arr[], int X){
        while(low<high){
            int mid = low + (high-low)/2;
            if(works(arr, X, mid) && !(works(arr, X, mid-1))){
                return mid;
            }else if(!(works(arr, X, mid))){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int X = sc.nextInt();
        System.out.println(binarySearch(1, 100000000, arr, X));
    }
}
