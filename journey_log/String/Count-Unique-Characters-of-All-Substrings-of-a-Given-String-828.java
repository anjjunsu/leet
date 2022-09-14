import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueLetterString(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> duplicate = new HashSet<>();
            Set<Character> unique = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char currChar = s.charAt(j);

                if (!unique.contains(currChar) && !duplicate.contains(currChar)) {
                    unique.add(currChar);
                } else {
                    unique.remove(currChar);
                    duplicate.add(currChar);
                }

                count += unique.size();
            }
        }

        return count;
    }
}
