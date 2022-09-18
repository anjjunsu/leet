import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (stack.isEmpty() || stack.peek().c != currChar) {
                stack.push(new Pair(currChar, 1));
            } else {
                stack.peek().count++;

                if (stack.peek().count == k) 
                    stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            Pair currPair = stack.pop();

            while (currPair.count > 0) {
                result.append(currPair.c);
                currPair.count--;
            }
        }

        return result.reverse().toString();
    }

    class Pair {

        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(" + c + ", " + String.valueOf(count) + ")";
        }
    }
}
