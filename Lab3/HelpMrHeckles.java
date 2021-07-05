import java.io.*;

public class HelpMrHeckles {

    public static String binSearchCols(long arr[][], long id, int m, int n){
        // This function is called when rows<cols or m<n.
        for(int i = 0 ; i<m ; i++){
            int low = 0;
            int high = n;
            while(low<high){
                int mid = low + (high-low)/2;
                if(arr[i][mid] == id){
                    return (i+1)+" "+(mid+1);
                }else if(arr[i][mid]<id){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
        }
        return -1+"";
    }

    public static String binSearchRows(long arr[][], long id, int m, int n){
        // This function is called when cols<rows or n<m.
        for(int i = 0 ; i<n ; i++){
            int low = 0;
            int high = m;
            while(low<high){
                int mid = low + (high-low)/2;
                if(arr[mid][i]==id){
                    return (mid+1)+" "+(i+1);
                }else if(arr[mid][i]<id){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
        }
        return -1+"";
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1[] = reader.readLine().split(" ");
        int M = Integer.parseInt(s1[0]); // no of rows
        int N = Integer.parseInt(s1[1]); // no of cols
        String s2[][] = new String[M][N];
        long arr[][] = new long[M][N];
        for(int i = 0 ; i<M ; i++){
            s2[i] = reader.readLine().split(" ");
            for(int j = 0 ; j<N ; j++){
                arr[i][j] = Long.parseLong(s2[i][j]);
            }
        }
        boolean rows;
        if(M<N) rows = true;
        else rows = false;
        int Q = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i<Q ; i++){
            long id = Long.parseLong(reader.readLine());
            if(rows){
                System.out.println(binSearchCols(arr, id, M, N));
            }else{
                System.out.println(binSearchRows(arr, id, M, N));
            }
        }
    }
}
