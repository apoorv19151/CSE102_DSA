import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class JoyApples {

    public static int[] getKthLargest(int arr[], int k){
        int ans[] = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(k>arr.length){
            for(int i = 0 ; i<ans.length ; i++){
                ans[i] = -1;
            }
            return ans;
        }
        for(int i = 0 ; i<k-1 ; i++){
            ans[i] = -1;
        }
        for(int i = 0 ; i<k ; i++){
            pq.add(arr[i]);
        }
        ans[k-1] = pq.peek();
        for(int i = k ; i<ans.length ; i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
            ans[i] = pq.peek();
        }
        return ans;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1[] = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int arr[] = new int[n];
        String s2[] = reader.readLine().split(" ");
        for(int i = 0 ; i<n ; i++){
            arr[i] = Integer.parseInt(s2[i]);
        }
        int ans[] = getKthLargest(arr, k);
        for(int i = 0 ; i<n ; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
