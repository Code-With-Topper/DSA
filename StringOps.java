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
