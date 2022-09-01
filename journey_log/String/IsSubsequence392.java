class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int pointer = 0;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            
            while (pointer < t.length()) {
                char tChar = t.charAt(pointer);
                
                pointer++;

                if (sChar == tChar) {
                    counter++;
                    break;
                }
            }
            
        }

        if (counter != s.length()) 
            return false;

        return true;
    }
}
