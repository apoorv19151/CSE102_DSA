import java.util.*;

public class LongestPerimeter {

    public static int[] prevSmaller(int arr[]){
        int P[] = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();
        P[0] = -1;
        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i-1]<arr[i]) {
                P[i] = i - 1;
                st.push(i - 1);
                continue;
            }
            while(!(st.isEmpty())){
                int j = st.peek();
                if(arr[j]<arr[i]){
                    P[i] = j; break;
                }else st.pop();
            }
            if(st.isEmpty()){
                P[i] = -1;
            }
        }
        return P;
    }

    public static int[] nextSmaller(int arr[]){
        int n = arr.length;
        int[] Q = new int[n];
        for(int i = 0 ; i<n ; i++){
            Q[i] = -1;
        }
        Stack<Integer> st = new Stack<Integer>();
        st.add(0);
        for(int i = 1 ; i<n ; i++){
            if(st.isEmpty()){
                st.push(i); continue;
            }
            while(!(st.isEmpty()) && arr[st.peek()]>arr[i]){
                Q[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return Q;
    }

    public static long maxPerimeter(int arr[]){
        int L[] = prevSmaller(arr);
        int R[] = nextSmaller(arr);
        long maxP = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++){
            if(L[i]==-1 && R[i]==-1){
                long p = 2*(arr.length + arr[i]);
                if(maxP<p) maxP = p;
            }else if(L[i]==-1){
                long p = 2*(R[i] + arr[i]);
                if(maxP<p) maxP = p;
            }else if(R[i]==-1){
                long p = 2*((arr.length-L[i]-1) + arr[i]);
                if(maxP<p) maxP = p;
            }else{
                int w = R[i]-L[i]-1;
                long p = 2*(w + arr[i]);
                if(maxP<p) maxP = p;
            }
        }
        return maxP;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxPerimeter(arr));
    }
}
