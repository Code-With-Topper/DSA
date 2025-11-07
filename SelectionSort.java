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
