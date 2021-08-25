import java.util.*;
import java.io.*;

class cell{
    int moves;
    int num;

    public cell(int moves, int num){
        this.moves = moves; // number of moves taken to reach position num
        this.num = num; // current position on board
    }
}

public class MinRollsDie {

    public static int getMinMoves(int cur, HashMap<Integer, Integer> ladder, HashMap<Integer, Integer> snakes){
        boolean visited[] = new boolean[101];
        for(int i = 0 ; i<visited.length ; i++){
            visited[i] = false;
        }
        Queue<cell> q = new LinkedList<>();
        cell t = new cell(0, cur);
        q.add(t);
        while(!q.isEmpty()){
            cell temp = q.poll();
            if(temp.num==100){
                return temp.moves;
            }
            for(int i = 1 ; i<=4 ; i++){
                cell newCell = new cell(temp.moves+1, temp.num+i);
                if(newCell.num<=100 && !visited[newCell.num]){
                    visited[newCell.num] = true;
                    if(ladder.containsKey(newCell.num)){
                        newCell.num = ladder.get(newCell.num);
                    }else if(snakes.containsKey(newCell.num)){
                        newCell.num = snakes.get(newCell.num);
                    }
                    q.add(newCell);
                }
            }
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
        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snakes = new HashMap<>();
        for(int i = 0 ; i<n ; i++){
            int key = Reader.nextInt();
            int value = Reader.nextInt();
            ladder.put(key, value);
        }
        for(int i = 0 ; i<m ; i++){
            int key = Reader.nextInt();
            int value = Reader.nextInt();
            snakes.put(key, value);
        }
        int moves = getMinMoves(1, ladder, snakes);
        System.out.println(moves);
    }
}
