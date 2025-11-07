# ✅ Complete DSA Programs in **Java**
All 15 programs are included below in this single README file for easy copy–paste and printing.

---

# ✅ 1. String Operations — `StringOps.java`
```java
import java.util.*;

public class StringOps {
    private static String readLine(Scanner sc) {
        String s = sc.nextLine();
        if (s == null) return "";
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- String Operations ---");
            System.out.print("1.Length  2.Copy  3.Concat  4.Compare  5.Reverse  0.Exit\nChoice: ");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e){ return; }
            if (choice == 0) break;
            switch (choice) {
                case 1: {
                    System.out.print("Enter string: ");
                    String a = readLine(sc);
                    System.out.println("Length = " + a.length());
                } break;
                case 2: {
                    System.out.print("Enter source: ");
                    String a = readLine(sc);
                    String b = new String(a);
                    System.out.println("Copied => \"" + b + "\"");
                } break;
                case 3: {
                    System.out.print("Enter first: ");
                    String a = readLine(sc);
                    System.out.print("Enter second: ");
                    String b = readLine(sc);
                    String c = a + b;
                    System.out.println("Concatenated => \"" + c + "\"");
                } break;
                case 4: {
                    System.out.print("Enter first: ");
                    String a = readLine(sc);
                    System.out.print("Enter second: ");
                    String b = readLine(sc);
                    int cmp = a.compareTo(b);
                    if (cmp == 0) System.out.println("Equal");
                    else if (cmp < 0) System.out.println("\"" + a + "\" < \"" + b + "\"");
                    else System.out.println("\"" + a + "\" > \"" + b + "\"");
                } break;
                case 5: {
                    System.out.print("Enter string: ");
                    String a = readLine(sc);
                    StringBuilder sb = new StringBuilder(a);
                    System.out.println("Reversed => \"" + sb.reverse().toString() + "\"");
                } break;
                default: System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
```



# ✅ 2. Array Operations — `ArrayOps.java`
```java
import java.util.*;

public class ArrayOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (true) {
            System.out.println("\n--- Array Ops ---");
            System.out.print("1.Create 2.Display 3.Insert@pos 4.Delete@pos 5.Search 0.Exit\nChoice: ");
            int choice = sc.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1: {
                    System.out.print("Size: "); int n = sc.nextInt();
                    arr.clear();
                    System.out.println("Enter " + n + " elements:");
                    for (int i=0;i<n;i++) arr.add(sc.nextInt());
                } break;
                case 2: {
                    for (int x: arr) System.out.print(x + " ");
                    System.out.println();
                } break;
                case 3: {
                    System.out.print("Position(0-based) and value: ");
                    int pos = sc.nextInt(), val = sc.nextInt();
                    if (pos < 0 || pos > arr.size()) System.out.println("Invalid");
                    else { arr.add(pos, val); System.out.println("Inserted."); }
                } break;
                case 4: {
                    System.out.print("Position(0-based): "); int pos = sc.nextInt();
                    if (pos < 0 || pos >= arr.size()) System.out.println("Invalid");
                    else { arr.remove(pos); System.out.println("Deleted."); }
                } break;
                case 5: {
                    System.out.print("Search key: "); int key = sc.nextInt();
                    int idx = arr.indexOf(key);
                    if (idx == -1) System.out.println("Not found");
                    else System.out.println("Found at index " + idx);
                } break;
                default: System.out.println("Invalid");
            }
        }
        sc.close();
    }
}
```



# ✅ 3. Stack (Array-based) — `StackArray.java`
```java
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
```



# ✅ 4. Infix to Postfix — `InfixToPostfix.java`
```java
import java.util.*;

public class InfixToPostfix {
    static int prec(char c){ if(c=='^') return 3; if(c=='*'||c=='/') return 2; if(c=='+'||c=='-') return 1; return 0; }
    static boolean rightAssoc(char c){ return c=='^'; }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix: ");
        String in = sc.nextLine();
        StringBuilder out = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();

        for (int i=0;i<in.length();i++){
            char c = in.charAt(i);
            if (Character.isWhitespace(c)) continue;
            if (Character.isLetterOrDigit(c)) out.append(c);
            else if (c=='(') st.push(c);
            else if (c==')'){
                while(!st.isEmpty() && st.peek()!='(') out.append(st.pop());
                if (!st.isEmpty() && st.peek()=='(') st.pop();
            } else {
                while(!st.isEmpty() && prec(st.peek()) > prec(c)) out.append(st.pop());
                while(!st.isEmpty() && prec(st.peek()) == prec(c) && !rightAssoc(c)) out.append(st.pop());
                st.push(c);
            }
        }
        while(!st.isEmpty()) out.append(st.pop());
        System.out.println("Postfix: " + out.toString());
        sc.close();
    }
}
```



# ✅ 5. Postfix Evaluation — `EvalPostfix.java`
```java
import java.util.*;

public class EvalPostfix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix (single-digit operands): ");
        String p = sc.nextLine();
        Deque<Integer> st = new ArrayDeque<>();
        for (int i=0;i<p.length();i++){
            char c = p.charAt(i);
            if (c==' '||c=='\n') continue;
            if (Character.isDigit(c)) st.push(c-'0');
            else {
                int b = st.pop();
                int a = st.pop();
                switch(c){
                    case '+': st.push(a+b); break;
                    case '-': st.push(a-b); break;
                    case '*': st.push(a*b); break;
                    case '/': st.push(b!=0? a/b : 0); break;
                    case '^': int r=1; for(int j=0;j<b;j++) r*=a; st.push(r); break;
                    default: System.out.println("Invalid op"); sc.close(); return;
                }
            }
        }
        System.out.println("Result = " + st.pop());
        sc.close();
    }
}
```



# ✅ 6. Queue Operations — `QueueArray.java`
```java
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
```



# ✅ 7. Circular Queue — `CircularQueue.java`
```java
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
```



# ✅ 8. Selection Sort — `SelectionSort.java`
```java
import java.util.*;

public class SelectionSort {
    static void selectionSort(int[] a){
        int n=a.length;
        for (int i=0;i<n-1;i++){
            int min=i;
            for (int j=i+1;j<n;j++) if (a[j]<a[min]) min=j;
            if (min!=i){ int t=a[i]; a[i]=a[min]; a[min]=t; }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        selectionSort(a);
        for(int x:a) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}
```



# ✅ 9. Insertion Sort — `InsertionSort.java`
```java
import java.util.*;

public class InsertionSort {
    static void insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
            int key=a[i], j=i-1;
            while(j>=0 && a[j]>key){ a[j+1]=a[j]; j--; }
            a[j+1]=key;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        insertionSort(a);
        for(int x:a) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}
```



# ✅ 10. Linked List Implementation — `LinkedListDemo.java`
```java
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
```



# ✅ 11. Shell Sort — `ShellSort.java`
```java
import java.util.*;

public class ShellSort {
    static void shellSort(int[] a){
        for (int gap=a.length/2; gap>0; gap/=2){
            for (int i=gap; i<a.length; i++){
                int temp=a[i], j=i;
                while (j>=gap && a[j-gap]>temp){ a[j]=a[j-gap]; j-=gap; }
                a[j]=temp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        shellSort(a);
        for(int x:a) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}
```



# ✅ 12. Linear Search — `LinearSearch.java`
```java
import java.util.*;

public class LinearSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        System.out.print("key: "); int key = sc.nextInt();
        for(int i=0;i<n;i++){
            if (a[i]==key){ System.out.println("Found at index " + i); sc.close(); return; }
        }
        System.out.println("Not found");
        sc.close();
    }
}
```



# ✅ 13. Binary Search — `BinarySearch.java`
```java
import java.util.*;

public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n (sorted ascending): "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        System.out.print("key: "); int key = sc.nextInt();
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==key){ System.out.println("Found at index " + mid); sc.close(); return; }
            else if(a[mid]<key) l=mid+1;
            else r=mid-1;
        }
        System.out.println("Not found");
        sc.close();
    }
}
```



# ✅ 14. Counting Sort — `CountingSort.java`
```java
import java.util.*;

public class CountingSort {
    static final int MAXV = 10000; // adjust if needed
    static void countingSort(int[] a){
        int[] cnt = new int[MAXV+1];
        for (int x: a) cnt[x]++;
        int idx = 0;
        for (int v=0; v<=MAXV; v++){
            while (cnt[v]-- > 0) a[idx++] = v;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        countingSort(a);
        for(int x:a) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}
```



# ✅ 15. Radix Sort — `RadixSort.java`
```java
import java.util.*;

public class RadixSort {
    static int getMax(int[] a){
        int mx = a[0];
        for(int i=1;i<a.length;i++) if (a[i]>mx) mx=a[i];
        return mx;
    }
    static void countingPass(int[] a, int exp){
        int n = a.length;
        int[] out = new int[n];
        int[] cnt = new int[10];
        for (int i=0;i<n;i++) cnt[(a[i]/exp)%10]++;
        for (int i=1;i<10;i++) cnt[i]+=cnt[i-1];
        for (int i=n-1;i>=0;i--){
            int d=(a[i]/exp)%10;
            out[--cnt[d]] = a[i];
        }
        System.arraycopy(out, 0, a, 0, n);
    }
    static void radixSort(int[] a){
        int m = getMax(a);
        for (int exp=1; m/exp>0; exp*=10) countingPass(a, exp);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        radixSort(a);
        for(int x:a) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}
```

