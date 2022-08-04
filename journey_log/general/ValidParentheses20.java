import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> lookUp = new HashMap<>();
        
        lookUp.put('[', ']');
        lookUp.put('(', ')');
        lookUp.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            Character curr = (Character) s.charAt(i);

            if (lookUp.containsKey(curr)) {
                stack.push(curr);
            } else if (lookUp.containsValue(curr)) {
                if (stack.isEmpty())
                    return false;

                Character topChar = stack.pop();

                if (lookUp.get(topChar) != curr) 
                    return false;

            } else {
                return false;
            }
        }

        if (!stack.isEmpty()) 
            return false;

        return true;
    }
}