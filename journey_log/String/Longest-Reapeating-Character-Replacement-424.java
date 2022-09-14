import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        Map<Character, Integer> charFreq = new HashMap<>();
        
        while (right < s.length()) {
            charFreq.putIfAbsent(s.charAt(right), 0);
            charFreq.put(s.charAt(right), charFreq.get(s.charAt(right)) + 1);

            int currWindowLen = right - left + 1;
            int mostFreqCharCount = Integer.MIN_VALUE;

            for (Integer v : charFreq.values()) {
                if (v > mostFreqCharCount)
                    mostFreqCharCount = v;
            }

            if (currWindowLen - mostFreqCharCount > k) {
                charFreq.put(s.charAt(left), charFreq.get(s.charAt(left)) - 1);
                left++;
            } else {
                if (currWindowLen > longest)
                    longest = currWindowLen;
            }
            right++;
        }

        return longest;
    }
}
