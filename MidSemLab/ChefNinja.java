import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefNinja {

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

    public static boolean check(long arr[], long M, long H){
        long minUnits = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i]>H) minUnits += (arr[i]-H);
            if(minUnits>=M) return true;
        }
        return false;
    }

    public static long findH(long arr[], long M){
        long low = 1;
        long high = 1000000000000000001L;
        while(low<high){
            long mid = low + (high-low)/2;
            if(check(arr,M,mid) && !(check(arr,M,mid+1))){
                return mid;
            }else if(!(check(arr,M,mid))){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return 0;
    }

    public static void main(String args[]) throws IOException
    {
        Reader.init(System.in);
        int N = Reader.nextInt();
        long arr[] = new long[N];
        for(int i = 0 ; i<N ; i++){
            arr[i] = Reader.nextLong();
        }
        long M = Reader.nextLong();
        System.out.println(findH(arr, M));
    }
}
