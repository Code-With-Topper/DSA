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
