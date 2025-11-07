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
