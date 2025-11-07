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
