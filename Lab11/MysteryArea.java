import java.util.*;
import java.io.*;

public class MysteryArea {

    public static boolean check(Character adj[][]){
        int n = adj.length;
        int m = adj[0].length;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(adj[i][j].equals('P')){
                    return false;
                }
            }
        }
        return true;
    }

    public static int getDays(Character adj[][], ArrayList<int[]> whistle){
        int n = adj.length; // number of rows
        int m = adj[0].length; // number of cols
        int days = 0;
        while(!whistle.isEmpty()){
            ArrayList<int[]> neighbours = new ArrayList<>();
            for(int i = 0 ; i<whistle.size() ; i++){
                int arr[] = whistle.get(i);
                int x = arr[0];
                int y = arr[1];
                if(x+1<n && y<m && adj[x+1][y].equals('P')){
                    int a[] = {x+1, y};
                    neighbours.add(a);
                    adj[x+1][y] = 'W';
                }
                if(x<n && y+1<m && adj[x][y+1].equals('P')){
                    int a[] = {x, y+1};
                    neighbours.add(a);
                    adj[x][y+1] = 'W';
                }
                if(x-1>=0 && y<m && adj[x-1][y].equals('P')){
                    int a[] = {x-1, y};
                    neighbours.add(a);
                    adj[x-1][y] = 'W';
                }
                if(x<n && y-1>=0 && adj[x][y-1].equals('P')){
                    int a[] = {x, y-1};
                    neighbours.add(a);
                    adj[x][y-1] = 'W';
                }
            }
            whistle.clear();
            for(int i = 0 ; i<neighbours.size() ; i++){
                whistle.add(neighbours.get(i));
            }
            days++;
        }
        if(check(adj)){
            return days-1;
        }
        return -1;
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    public static void main(String args[]) throws IOException
    {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        Character matrix[][] = new Character[n][m];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                matrix[i][j] = Reader.next().charAt(0);
                if(matrix[i][j].equals('W')){
                    int arr[] = {i, j};
                    list.add(arr);
                }
            }
        }
        System.out.println(getDays(matrix, list));
    }
}
