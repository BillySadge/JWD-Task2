package by.epam.jwd.tasks;

import java.util.Stack;

public class Logic {

    private static void cal(Stack<Integer> st, int val, char sign){
        if (sign == '+') {
            st.push(val);
        } else if (sign == '-') {
            st.push(-val);
        } else if (sign == '*') {
            int a = st.pop();
            int ans = a * val;
            st.push(ans);
        } else if (sign == '/') {
            int a = st.pop();
            int ans = a / val;
            st.push(ans);
        }
    }
    public static int calculate(String str){
        Stack<Pair> stP = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int n = str.length();
        char sign = '+';
        for(int i = 0; i < n;i++){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(str.charAt(i))) {
                    val = val * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--;
                cal(st, val, sign);


            }else if (ch == '('){
                stP.push(new Pair(st,sign));
                sign = '+';
                st = new Stack<>();
            }else if(ch == ')'){
                int val = 0;
                while(st.size() > 0){
                    val += st.pop();
                }
                Pair p = stP.pop();
                st = p.st;
                sign = p.sign;
                cal(st, val, sign);
            }

            else if(ch != ' '){
                sign = ch;
            }
        }
        int sum = 0;
        while(st.size() > 0){
            sum += st.pop();
        }

        return sum;
    }

}
