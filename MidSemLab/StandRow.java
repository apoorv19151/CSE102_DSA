import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StandRow {

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

    public static int getMoves(int arr[]){
        int moves = 0;
        int n = arr.length;
        int i = 0;
        while(i<n-1){
            if(arr[i]<=arr[i+1]){
                i++; continue;
            }
            int temp = arr[i+1];
            for(int j = i ; j>=0 ; j--){
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
            i = 0;
            moves++;
        }
        return moves;
    }

    public static void main(String args[]) throws IOException
    {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = Reader.nextInt();
        }
        System.out.println(getMoves(arr));
    }
}
