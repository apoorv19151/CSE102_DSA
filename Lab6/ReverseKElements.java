import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseKElements {

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
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

        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
    }

    static Queue<Integer> queue;

    static void reverseKElements(int k) throws IOException
    {
        if(k>queue.size()){
            System.out.println(-1);
            return;
        }
        Stack<Integer> st = new Stack<>();
        while(k>0){
            st.push(queue.poll());
            k--;
        }
        while(!(st.isEmpty())){
            System.out.print(st.pop()+" ");
        }
        while(!(queue.isEmpty())){
            System.out.print(queue.poll()+" ");
        }
    }

    public static void main(String args[]) throws IOException
    {
        queue = new LinkedList<Integer>();
        Reader.init(System.in);
        int n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            queue.add(Reader.nextInt());
        }
        int k=Reader.nextInt();
        reverseKElements(k);
    }
}
