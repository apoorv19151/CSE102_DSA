import java.util.*;

//class Node{
//    long data;
//    Node left;
//    Node right;
//
//    public Node(long n){
//        data = n;
//        left = null;
//        right = null;
//    }
//}

public class XorTree {

    public static long getXor(Node node){
        if(node.left != null && node.right != null){
            return getXor(node.left)^node.data^getXor(node.right);
        }else if(node.left != null){
            return getXor(node.left)^node.data;
        }else if(node.right != null){
            return node.data^getXor(node.right);
        }else{
            return node.data;
        }
    }

    public static void getXorTree(Node root){
        if(root != null){
            getXorTree(root.left);
            getXorTree(root.right);
            System.out.print(getXor(root)+" ");
        }
        return;
    }

    public static Node takeInput(){
        Scanner sc = new Scanner(System.in);
        Queue<Node> queue = new LinkedList<Node>();
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        Node root = new Node(rootData);
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            int leftChild = sc.nextInt();
            if(leftChild!=-1){
                Node left = new Node(leftChild);
                front.left = left;
                queue.add(left);
            }
            int rightChild = sc.nextInt();
            if(rightChild!=-1){
                Node right = new Node(rightChild);
                front.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String args[]){
        Node root = takeInput();
        getXorTree(root);
    }
}
