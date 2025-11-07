import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d){ data=d; }
}
public class LinkedListDemo {
    static Node head = null;

    static void insertEnd(int x){
        Node nn = new Node(x);
        if (head == null){ head = nn; return; }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = nn;
    }
    static void insertBegin(int x){
        Node nn = new Node(x);
        nn.next = head;
        head = nn;
    }
    static void deleteValue(int x){
        Node t=head, p=null;
        while (t!=null && t.data!=x){ p=t; t=t.next; }
        if (t==null){ System.out.println("Not found"); return; }
        if (p==null) head = head.next;
        else p.next = t.next;
        System.out.println("Deleted " + x);
    }
    static void display(){
        Node t=head;
        while(t!=null){ System.out.print(t.data + " "); t=t.next; }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\n1.InsBegin 2.InsEnd 3.DeleteVal 4.Display 0.Exit\nChoice: ");
            int ch = sc.nextInt();
            if (ch==0) break;
            if (ch==1){ System.out.print("Val: "); insertBegin(sc.nextInt()); }
            else if (ch==2){ System.out.print("Val: "); insertEnd(sc.nextInt()); }
            else if (ch==3){ System.out.print("Val: "); deleteValue(sc.nextInt()); }
            else if (ch==4) display();
            else System.out.println("Invalid");
        }
        sc.close();
    }
}
