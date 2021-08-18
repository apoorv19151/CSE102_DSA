import java.util.*;
import java.io.*;

public class RohanHatesApples {

    public static String Solution(ArrayList<String> list){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i<list.size() ; i++){
            String s = list.get(i);
            int j = 0;
            String temp = "";
            while(j<s.length()){
                if(s.charAt(j) != 'i' && !Character.isDigit(s.charAt(j))){
                    temp += s.charAt(j);
                }
                j++;
            }
            if(!map.containsKey(temp)){
                map.put(temp, 1);
            }else{
                int val = map.get(temp);
                map.put(temp, val+1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> i : map.entrySet()){
            int val = (int)i.getValue();
            if(val>max) max = val;
        }
        return map.size()+" "+max;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            list.add(reader.readLine());
        }
        System.out.println(Solution(list));
    }
}
