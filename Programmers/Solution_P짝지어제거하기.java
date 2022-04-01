import java.util.Stack;

public class P_짝지어제거하기 {

    public static void main(String[] args) {
        String s = "cdcd";
        Stack<Character> st = new Stack<>();
        char c;

        for(int i = 0; i < s.length();i++) {
            c = s.charAt(i);

            if(!st.empty()) {
                if(st.peek() == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }
        }

        System.out.println(st.size() > 0 ? -1 : 0);
    }
}
