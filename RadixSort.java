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
