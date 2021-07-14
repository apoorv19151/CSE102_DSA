import java.io.*;

class Node{

    int data;
    Node next;

    public Node(){
        data = 0;
        next = null;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList {

    Node head;

    SinglyLinkedList() {
        head = null;
    }

    public static boolean isEmpty(SinglyLinkedList list) {
        return (list.head == null);
    }

    public static void add(Node e, SinglyLinkedList list) {
        if (list.head == null) {
            list.head = e;
            return;
        }
        e.next = list.head;
        list.head = e;
        return;
    }
}

public class VanyaAndSecretNumber {

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1[] = reader.readLine().split(" ");
        SinglyLinkedList list1 = new SinglyLinkedList();
        if(s1.length>1){
            for(int i = s1.length-2 ; i>=0 ; i--){
                Node p = new Node(Integer.parseInt(s1[i]));
                list1.add(p, list1);
            }
        }
        String s2[] = reader.readLine().split(" ");
        SinglyLinkedList list2 = new SinglyLinkedList();
        if(s2.length>1){
            for(int i = 0 ; i<s2.length-1 ; i++){
                Node p = new Node(Integer.parseInt(s2[i]));
                list2.add(p, list2);
            }
        }
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while((temp1 != null) && (temp2 != null)){
            System.out.print(temp1.data+" ");
            System.out.print(temp2.data+" ");
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            System.out.print(temp1.data+" ");
            temp1 = temp1.next;
        }
        while(temp2 != null){
            System.out.print(temp2.data+" ");
            temp2 = temp2.next;
        }
    }
}
