import java.util.*;

public class MaxStack {

    static int arr[];
    static int top;
    static int max[];

    public MaxStack(int size){
        arr = new int[size];
        top = -1;
        max = new int[size];
        for(int i = 0 ; i<size ; i++){
            max[i] = -1;
        }
    }

    public static void push(int n){
        top++;
        if(top==arr.length){
            System.out.println("Stack Overflow");
            top--;
            return;
        }
        arr[top] = n;
        if(top==0){
            max[top] = n;
            return;
        }
        if(max[top-1]<n){
            max[top] = n;
        }else{
            max[top] = max[top-1];
        }
    }

    public static int pop(){
        if(top==-1){
            return -1;
        }
        max[top] = -1;
        top--;
        return arr[top+1];
    }

    public static boolean isEmpty(){
        return (top==-1);
    }

    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }

    public static int getSize(){
        return top+1;
    }

    public static int getMax(){
        if(top==-1){
            return -1;
        }
        return max[top];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        sc.nextLine();
        MaxStack st = new MaxStack(Q);
        for(int i = 0 ; i<Q ; i++){
            String s = sc.nextLine();
            if(s.length()>1){
                int n = Integer.parseInt(s.split(" ")[1]);
                st.push(n);
            }else if(Integer.parseInt(s)==2){
                System.out.println(st.pop());
            }else if(Integer.parseInt(s)==3){
                System.out.println(st.peek());
            }else{
                System.out.println(getMax());
            }
        }
    }
}
