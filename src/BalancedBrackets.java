import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> set = new Stack();
        for (Character ch : arr) {
            if (ch == '{' || ch == '[' || ch == '(' || ch == '<') {
                set.push(ch);
            } else if (ch == ']') {
                if (set.isEmpty() || set.peek() != '[') {
                    return false;
                }
                set.pop();
            } else if (ch == ')') {
                if (set.isEmpty() ||  set.peek() != '(')
                    return false;
                set.pop();
            } else if (ch == '}') {
                if (set.isEmpty() ||  set.peek() != '{')
                    return false;
                set.pop();
            }  else if (ch == '>'){
                if (set.isEmpty() ||  set.peek() != '<')
                return false;
                set.pop();
            }
        }
        return set.size() == 0;
    }

}

//    public static boolean balancedBrackets1(String s) {
//
//        Stack<Character> stack = new Stack<Character>();
//        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
//        bracketPairs.put(')', '(');
//        bracketPairs.put(']', '[');
//        bracketPairs.put('}', '{');
//        bracketPairs.put('>', '<');
//
//        for (int i = 0; i < s.length(); i += 1) {
//
//            // If character is opening bracket
//            if (bracketPairs.containsValue(s.charAt(i))) {
//                stack.push(s.charAt(i));
//            }
//            // Else, if character is closing bracket
//            else if (bracketPairs.containsKey(s.charAt(i))) {
//                // Closing bracket without matching opening bracket
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                // Check that most recent bracket on stack matches
//                Character mostRecentBracket = stack.pop();
//                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
//                    return false;
//                }
//            }
//        }
//
//        return stack.isEmpty();
//    }
//
