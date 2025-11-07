import java.util.*;

public class QueueArray {
    static final int MAX = 100;
    static int[] q = new int[MAX];
    static int front = 0, rear = -1;

    static void enqueue(int x){ if (rear==MAX-1) System.out.println("Overflow"); else q[++rear]=x; }
    static int dequeue(){ if (front>rear){ System.out.println("Underflow"); return -1;} return q[front++]; }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\n1.Enqueue 2.Dequeue 3.Display 0.Exit\nChoice: ");
            int ch = sc.nextInt();
            if (ch==0) break;
            if (ch==1){ System.out.print("Value: "); enqueue(sc.nextInt()); }
            else if (ch==2){ int x=dequeue(); if(x!=-1) System.out.println("Dequeued " + x); }
            else if (ch==3){ for(int i=front;i<=rear;i++) System.out.print(q[i]+" "); System.out.println(); }
            else System.out.println("Invalid");
        }
        sc.close();
    }
}
