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
