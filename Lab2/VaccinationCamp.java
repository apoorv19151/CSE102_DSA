import java.util.*;

public class VaccinationCamp {

    public static int[] getVaccineCentres(int V[], int H[]){
        int i = 0;
        int j = 0;
        int ans[] = new int[H.length];
        while(i<H.length && j<V.length){
            if(V[j]>=H[i]){
                ans[i] = V.length-j;
                i++;
            }else{
                j++;
            }
        }
        while(i<H.length){
            ans[i] = 0;
            i++;
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int V[] = new int[n1];
        for(int i = 0 ; i<n1 ; i++){
            V[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int H[] = new int[n2];
        for(int i = 0 ; i<n2 ; i++){
            H[i] = sc.nextInt();
        }
        int ans[] = getVaccineCentres(V, H);
        for(int i = 0 ; i<n2 ; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
