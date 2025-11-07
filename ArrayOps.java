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
