import java.util.*;

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

public class Maze {

    public static long getMaxScore(Node root){
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return root.data;
        }else if(root.left==null){
            return root.data+getMaxScore(root.right);
        }else if(root.right==null){
            return root.data+getMaxScore(root.left);
        }else{
            return root.data+Math.max(getMaxScore(root.left), getMaxScore(root.right));
        }
    }

    public static Node takeInput(){
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<Node>();
        String treeStr = sc.nextLine();
        String[] tree = treeStr.split("\\s+");
        if(tree[0].equals("n")){
            return null;
        }
        Node root = new Node(Integer.parseInt(tree[0]));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < tree.length){
            Node front = queue.poll();
            if(!tree[i].equals("n")){
                int leftChild = Integer.parseInt(tree[i]);
                Node left = new Node(leftChild);
                front.left = left;
                queue.add(left);
            }
            i++;
            if(i >= tree.length) {
                break;
            }
            if(!tree[i].equals("n")){
                int rightChild = Integer.parseInt(tree[i]);
                Node right = new Node(rightChild);
                front.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static void main(String args[])
    {
        Node root = takeInput();
        System.out.println(getMaxScore(root));
    }
}
