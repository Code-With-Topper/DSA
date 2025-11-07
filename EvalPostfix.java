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
