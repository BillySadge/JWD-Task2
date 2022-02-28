package by.epam.jwd.tasks;


import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValid(String str) throws IncorrectExpression{
        if(!isMatchesPattern(str)){
            throw new IncorrectExpression("Expression do not matches pattern");
        }
        if(!isBalanced(str)){
            throw new IncorrectExpression("Expression contains unbalanced parentheses");
        }
        return (isMatchesPattern(str) && isBalanced(str));
    }

    private static final Pattern p = Pattern.compile("[\\d\\(\\+\\-\\s+][\\s+\\d\\(\\)\\-\\+\\/\\*]+[\\s+\\d\\)]");
    public static boolean isMatchesPattern(String str){
        Matcher m = p.matcher(str);
        return m.matches();
    }

    // parentheses
    public static boolean isBalanced(String str) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
