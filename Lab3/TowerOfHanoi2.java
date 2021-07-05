import java.io.*;

public class TowerOfHanoi2 {

    public static int countMoves(int discs, int cur, int dest, int aux){
        if(discs==1){
            return 1;
        }
        if(cur==2){
            return 1;
        }
        return countMoves(discs-1, cur, aux, dest) + 1 + countMoves(discs-1, aux, dest, cur);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if(n==0){
            System.out.println(0);
        }else{
            System.out.println(countMoves(n, 1, 3, 2));
        }
    }
}
