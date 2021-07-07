import java.io.*;

class MinStack {

    int arr[];
    int top;
    int min[];

    public MinStack(int size){
        arr = new int[size];
        top = -1;
        min = new int[size];
        for(int i = 0 ; i<size ; i++){
            min[i] = -1;
        }
    }

    public static void push(int n, MinStack st){
        st.top++;
        if(st.top==st.arr.length){
            System.out.println("Stack Overflow");
            st.top--;
            return;
        }
        st.arr[st.top] = n;
        if(st.top==0){
            st.min[st.top] = n;
            return;
        }
        if(st.min[st.top-1]>n){
            st.min[st.top] = n;
        }else{
            st.min[st.top] = st.min[st.top-1];
        }
    }

    public static int pop(MinStack st){
        if(st.top==-1){
            return -1;
        }
        st.min[st.top] = -1;
        st.top--;
        return st.arr[st.top+1];
    }

    public static boolean isEmpty(MinStack st){
        return (st.top==-1);
    }

    public static int peek(MinStack st){
        if(isEmpty(st)){
            return -1;
        }
        return st.arr[st.top];
    }

    public static int getSize(MinStack st){
        return st.top+1;
    }

    public static int getMin(MinStack st){
        if(st.top==-1){
            return -1;
        }
        return st.min[st.top];
    }
}

public class MinQueue {

    public static void enqueue(int n, MinStack st1){
        st1.push(n, st1);
    }

    public static int dequeue(MinStack st1, MinStack st2){
        if(st1.isEmpty(st1) && st2.isEmpty(st2)){
            return -1;
        }
        if(st2.isEmpty(st2)){
            while(!(st1.isEmpty(st1))){
                st2.push(st1.pop(st1), st2);
            }
        }
        return st2.pop(st2);
    }

    public static int getFront(MinStack st1, MinStack st2){
        if(st1.isEmpty(st1) && st2.isEmpty(st2)){
            return -1;
        }
        if(st2.isEmpty(st2)){
            while(!(st1.isEmpty(st1))){
                st2.push(st1.pop(st1), st2);
            }
        }
        return st2.peek(st2);
    }

    public static int queueGetMin(MinStack st1, MinStack st2){
        if(st1.isEmpty(st1) && st2.isEmpty(st2)){
            return -1;
        }else if(st1.isEmpty(st1)){
            return st2.getMin(st2);
        }else if(st2.isEmpty(st2)){
            return st1.getMin(st1);
        }else{
            return Math.min(st1.getMin(st1), st2.getMin(st2));
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(reader.readLine());
        MinQueue q = new MinQueue();
        MinStack st1 = new MinStack(500000);
        MinStack st2 = new MinStack(500000);
        for(int i = 0 ; i<Q ; i++){
            String s = reader.readLine();
            if(s.length()>1){
                int n = Integer.parseInt(s.split(" ")[1]);
                MinQueue.enqueue(n, st1);
            }else if(Integer.parseInt(s)==2){
                System.out.println(MinQueue.dequeue(st1, st2));
            }else if(Integer.parseInt(s)==3){
                System.out.println(MinQueue.getFront(st1, st2));
            }else{
                System.out.println(MinQueue.queueGetMin(st1, st2));
            }
        }
    }
}
