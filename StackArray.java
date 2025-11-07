import java.util.*;

public class StackArray {
    static final int MAX = 100;
    static int[] s = new int[MAX];
    static int top = -1;

    static void push(int x){ if (top == MAX-1) System.out.println("Overflow"); else s[++top] = x; }
    static int pop(){ if (top == -1){ System.out.println("Underflow"); return -1; } return s[top--]; }
    static int peek(){ if (top == -1){ System.out.println("Empty"); return -1; } return s[top]; }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\n1.Push 2.Pop 3.Peek 4.Display 0.Exit\nChoice: ");
            int ch = sc.nextInt();
            if (ch==0) break;
            switch(ch){
                case 1: System.out.print("Value: "); push(sc.nextInt()); break;
                case 2: { int x=pop(); if(x!=-1) System.out.println("Popped " + x); } break;
                case 3: { int x=peek(); if(x!=-1) System.out.println("Top " + x); } break;
                case 4: for(int i=top;i>=0;i--) System.out.print(s[i]+" "); System.out.println(); break;
                default: System.out.println("Invalid");
            }
        }
        sc.close();
    }
}
