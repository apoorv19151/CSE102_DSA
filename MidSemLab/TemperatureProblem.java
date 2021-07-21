import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TemperatureProblem {

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }

        static long nextLong() throws IOException {
            return Long.parseLong( next() );
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
    }

    public static long[] getDays(long arr[]){
        long ans[] = new long[arr.length];
        for(int i = 0 ; i<arr.length ; i++){
            ans[i] = 0;
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0 ; i<arr.length ; i++){
            while(!(st.isEmpty()) && arr[i]>arr[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String args[]) throws IOException
    {
        Reader.init(System.in);
        int n = Reader.nextInt();
        long arr[] = new long[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = Reader.nextLong();
        }
        long ans[] = getDays(arr);
        for(int i = 0 ; i<n ; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
