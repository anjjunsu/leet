package journey_log;
/*
Junsu An
Jan 21, 2021
#5
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    // O(n), But it's only faster than 34% of Java submission
    public int longestPalindrome_v1(String s) {
        Map <String, Integer> occurences = new HashMap<String, Integer>();
        int length = 0;
        boolean firstOne = true;

        // Count number of chars in a string
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (!occurences.containsKey(c)) {
                occurences.put(c, 1);
            } else {
                occurences.put(c, occurences.get(c) + 1);
            }
        }

        // Iterate through occurrences
        for (String key : occurences.keySet()) {
            int o = occurences.get(key);

            // If occurence is even, we can add to length by (occurence)
            if (o % 2 == 0) {
                length += o;
            } else {
                // if occurence is odd and greater than 2, we can add (occurence - 1) to length
                if (o > 2) {
                    length += (o - 1);
                    if (firstOne) {
                        length++;
                        firstOne = false;
                    }
                }
                // if this occurence is 1, if we can use only one 1 occurence to make palindrome
                if (firstOne) {
                    length++;
                    firstOne = false;
                } 
            }
        }


        return length;
    }

    public int longestPalindrome_v2(String s) {
        int length = 0;
        int[] occurences = new int[128]; // Size = 52 b/c there are 26 alphabet and for both capital and lower case letters

        // Count the number of char occurences
        for (int i = 0; i < s.length(); i++) {
            occurences[s.charAt(i)]++;  // We can use char as index of array
        }

        for (int count : occurences) {
            length += (count / 2) * 2;
            // If count is odd and never added single character case to palindrome
            if (count % 2 == 1 && length % 2 == 0) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Solution soln = new Solution();
        
        String s1 = "abccccdd";
        int r1 = soln.longestPalindrome_v1(s1);
        System.out.println(r1);

        String s2 = "bb";
        System.out.println(soln.longestPalindrome_v1(s2));

        String s3 = "a";
        System.out.println(soln.longestPalindrome_v1(s3));
    }
}

