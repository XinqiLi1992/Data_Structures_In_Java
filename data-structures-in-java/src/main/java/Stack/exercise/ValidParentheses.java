package Stack.exercise;

import Stack.ArrayStack;

public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                char right = s.charAt(i);
                if ((left == '{' && right != '}')
                        || (left == '[' && right != ']')
                        || (left == '(' && right != ')')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
