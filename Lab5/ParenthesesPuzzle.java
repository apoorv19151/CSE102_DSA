import java.util.*;

public class ParenthesesPuzzle {

    public static int parenthesesChecker(String s){
        if(s.length()==0){
            return 1;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i = 0 ; i<s.length() ; i++){
            if((s.charAt(i)==')' || s.charAt(i)=='}') && st.isEmpty()){
                return 0;
            }else if(s.charAt(i)=='(' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(st.peek()=='('){
                    st.pop();
                }else{
                    return 0;
                }
            }else if(s.charAt(i)=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }else{
                    return 0;
                }
            }
        }
        if(st.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(parenthesesChecker(s));
    }
}
