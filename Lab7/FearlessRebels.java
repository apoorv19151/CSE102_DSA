import java.io.*;

class NodeDLL{

    NodeDLL next;
    NodeDLL prev;
    int data;

    public NodeDLL(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DLL {

    NodeDLL head;
    NodeDLL tail;
    int size;

    public DLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static boolean isEmpty(DLL list) {
        return list.head == null;
    }

    public static void insertAtHead(DLL list, NodeDLL node) {
        if(list.isEmpty(list)) {
            list.head = node;
            list.tail = node;
            node.next = null;
            node.prev = null;
            list.size++;
            return;
        }
        node.next = list.head;
        list.head.prev = node;
        list.head = node;
        list.size++;
    }

    public static void deleteNode(DLL list, NodeDLL node){
        NodeDLL p1 = node.prev;
        NodeDLL p2 = node.next;
        if(list.head==node && list.tail==node){
            list.head = null;
            list.tail = null;
        }
        if(p1==null){
            list.head = node.next;
            node.next.prev = null;
            node.next = null;
            list.size--;
            return;
        }
        if(p2==null){
            list.tail = node.prev;
            node.prev.next = null;
            node.prev = null;
            list.size--;
            return;
        }
        p1.next = p2;
        p2.prev = p1;
        node.next = null;
        node.prev = null;
        list.size--;
        return;
    }
}

public class FearlessRebels {

    public static int rebelLeft(int n){
        DLL list = new DLL();
        for(int i = n ; i>=1 ; i--){
            NodeDLL node = new NodeDLL(i);
            list.insertAtHead(list, node);
        }
        int turn = 1;
        NodeDLL cur = list.head;
        while(list.size != 1){
            if(list.size==2 && turn%2==0){
                if(cur.next != null){
                    return cur.next.data;
                }else{
                    return cur.prev.data;
                }
            }
            if(turn%2==1){
                if(cur.next != null){
                    list.deleteNode(list, cur.next);
                }else{
                    list.deleteNode(list, list.head);
                }
            }else{
                if(cur.next != null){
                    if(cur.next.next != null){
                        list.deleteNode(list, cur.next.next);
                    }else{
                        list.deleteNode(list, list.head);
                    }
                }else{
                    list.deleteNode(list, list.head.next);
                }
            }
            if(cur.next != null){
                cur = cur.next;
            }else{
                cur = list.head;
            }
            turn++;
        }
        return list.head.data;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(rebelLeft(n));
    }
}
