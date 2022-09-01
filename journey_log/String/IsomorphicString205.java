import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> mappedChar = new HashSet<>();
        
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!charMap.containsKey(sChar)) {
                if (mappedChar.contains(tChar)) 
                    return false;

                charMap.put(sChar, tChar);
                mappedChar.add(tChar);

            } else if (charMap.get(sChar) != tChar) {
                return false;
            }
        }

        return true;
    }
}
