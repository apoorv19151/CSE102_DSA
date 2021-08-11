import java.util.*;
import java.io.*;

class Node{
    long data;
    Node left;
    Node right;

    public Node(long n){
        data = n;
        left = null;
        right = null;
    }
}

public class PostOrderTraversal {

    public static Node buildTree(String s, int i, int j){
        if(j-i<2) return null;
        if(s.charAt(i+1)=='('){
            Stack<Character> st = new Stack<>();
            int k = i+1;
            st.push(s.charAt(i));
            while(!st.isEmpty()){
                k++;
                if(s.charAt(k)=='('){
                    st.push('(');
                }else if(s.charAt(k)==')'){
                    st.pop();
                }
            }
            int root_data = Character.getNumericValue(s.charAt(k + 1));
            Node root = new Node(root_data);
            root.left = buildTree(s, i+1, k);
            root.right = buildTree(s, k+2, j-1);
            return root;
        }else{
            int root_data = Character.getNumericValue(s.charAt(i + 1));
            Node root = new Node(root_data);
            root.left = null;
            root.right = buildTree(s, i+2, j-1);
            return root;
        }
    }

    public static void getPostOrder(Node root){
        if(root != null){
            getPostOrder(root.left);
            getPostOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Node root = buildTree(s, 0, s.length()-1);
        getPostOrder(root);
    }
}
