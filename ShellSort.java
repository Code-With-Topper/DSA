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
