import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> set = new Stack();
        for (Character ch : arr) {
            if (ch == '(') {
                set.push(ch);
            } else if (ch == ')') {
                if (set.isEmpty() ||  set.peek() != '(')
                    return false;
                set.pop();
            }
        }
        return set.size() == 0;
    }
}


//    public static boolean balancedParentheses1(String s) {
//        int numUnclosedOpenParens = 0;
//        for (int i = 0; i < s.length(); i += 1) {
//            if (s.charAt(i) == '(') {
//                numUnclosedOpenParens += 1;
//            }
//            else if (s.charAt(i) == ')') {
//                numUnclosedOpenParens -= 1;
//            }
//
//            if (numUnclosedOpenParens < 0) {
//                return false;
//            }
//        }
//
//        return numUnclosedOpenParens == 0;
//    }

//    As comments in your file, answer the following as you read through this step and the solutions:
//
//        What is the runtime complexity of your solutions for Step 1 and Step 2? 1. O(n) 2. O(n)
//
//        What is the runtime complexity for each solution? 1. O(n) 2. O(n)
//
//        How do the solutions compare to yours? What improvements do you think you could have made to your solution?
// They seem about the same.  I could use the loop to avoid creating a new stack in the first to save memory though.
//The second one, mine is maybe a little better since you don't have to hash map things.
//
//        How would the implementation of the Stack from Step 3 change if you were to implement a queue?
//The puts would be reversed.