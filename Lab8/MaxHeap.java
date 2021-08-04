import java.io.*;

public class MaxHeap {

    int arr[];
    int max_size;
    int size;

    public MaxHeap(int n){
        arr = new int[n];
        max_size = n;
        size = 0;
    }

    public static void buildHeap(MaxHeap h){
        int n = h.size;
        for(int i = n/2 - 1 ; i>=0 ; i--){
            heapify(h.arr, i, n);
        }
        return;
    }

    public static void heapify(int arr[], int i, int n){
        int left_child = 2*i+1;
        int right_child = 2*i+2;
        int largest = i;
        if(left_child<n && arr[left_child]>arr[largest]){
            largest = left_child;
        }
        if(right_child<n && arr[right_child]>arr[largest]){
            largest = right_child;
        }
        if(i != largest){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }

    public static void insert(MaxHeap h, int e){
        int i = h.size;
        h.arr[h.size] = e;
        h.size++;
        int parent = (i-1)/2;
        while(h.arr[parent]<h.arr[i]){
            int temp = h.arr[parent];
            h.arr[parent] = h.arr[i];
            h.arr[i] = temp;
            i = parent;
            parent = (i-1)/2;
        }
        return;
    }

    public static void delete(MaxHeap h, int k){ // k is the index of the element to be deleted.
        h.arr[k] = h.arr[h.size-1];
        h.size--;
        heapify(h.arr, k, h.size);
        return;
    }

    public static int extractMax(MaxHeap h){
        if(h.size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        int max = h.arr[0];
        h.arr[0] = h.arr[h.size-1];
        h.size--;
        heapify(h.arr, 0, h.size);
        return max;
    }

    public static int getMax(MaxHeap h){
        if(h.size==0){
            return -1;
        }
        return h.arr[0];
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(reader.readLine());
        MaxHeap h = new MaxHeap(1000);
        for(int i = 0 ; i<Q ; i++){
            String s[] = reader.readLine().split(" ");
            if(s.length==2){
                int q1 = Integer.parseInt(s[0]);
                int q2 = Integer.parseInt(s[1]);
                if(q1==1){
                    insert(h, q2);
                }else{
                    delete(h, q2);
                }
            }else{
                int q = Integer.parseInt(s[0]);
                if(q==2){
                    extractMax(h);
                }else{
                    System.out.println(getMax(h));
                }
            }
        }
    }
}
