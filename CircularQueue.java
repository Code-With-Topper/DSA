import java.util.*;

public class CircularQueue {
    static final int MAX = 5;
    static int[] cq = new int[MAX];
    static int front = -1, rear = -1;

    static boolean isFull(){ return (front==0 && rear==MAX-1) || ((rear+1)%MAX)==front; }
    static boolean isEmpty(){ return front==-1; }

    static void enqueue(int x){
        if (isFull()){ System.out.println("Overflow"); return; }
        if (isEmpty()) front=rear=0;
        else rear = (rear+1)%MAX;
        cq[rear]=x;
    }
    static int dequeue(){
        if (isEmpty()){ System.out.println("Underflow"); return -1; }
        int val=cq[front];
        if (front==rear) front=rear=-1;
        else front=(front+1)%MAX;
        return val;
    }
    static void display(){
        if (isEmpty()){ System.out.println("Empty"); return; }
        int i=front;
        while (true){
            System.out.print(cq[i] + " ");
            if (i==rear) break;
            i=(i+1)%MAX;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\n1.Enqueue 2.Dequeue 3.Display 0.Exit\nChoice: ");
            int ch = sc.nextInt();
            if (ch==0) break;
            if (ch==1){ System.out.print("Value: "); enqueue(sc.nextInt()); }
            else if (ch==2){ int x=dequeue(); if(x!=-1) System.out.println("Dequeued " + x); }
            else if (ch==3) display();
            else System.out.println("Invalid");
        }
        sc.close();
    }
}
