import java.util.*;

public class InfixToPostfix {
    static int prec(char c){ if(c=='^') return 3; if(c=='*'||c=='/') return 2; if(c=='+'||c=='-') return 1; return 0; }
    static boolean rightAssoc(char c){ return c=='^'; }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix: ");
        String in = sc.nextLine();
        StringBuilder out = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();

        for (int i=0;i<in.length();i++){
            char c = in.charAt(i);
            if (Character.isWhitespace(c)) continue;
            if (Character.isLetterOrDigit(c)) out.append(c);
            else if (c=='(') st.push(c);
            else if (c==')'){
                while(!st.isEmpty() && st.peek()!='(') out.append(st.pop());
                if (!st.isEmpty() && st.peek()=='(') st.pop();
            } else {
                while(!st.isEmpty() && prec(st.peek()) > prec(c)) out.append(st.pop());
                while(!st.isEmpty() && prec(st.peek()) == prec(c) && !rightAssoc(c)) out.append(st.pop());
                st.push(c);
            }
        }
        while(!st.isEmpty()) out.append(st.pop());
        System.out.println("Postfix: " + out.toString());
        sc.close();
    }
}
