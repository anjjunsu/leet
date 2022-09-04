class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;

        for (String word : words) {
            if(isExpressiveWord(s, word))
                count++;
        }

        return count;
    }

    private boolean isExpressiveWord(String s, String word) {

        int sIdx = 0;
        int wordIdx = 0;

        while (sIdx < s.length() && wordIdx < word.length()) {
            if (s.charAt(sIdx) != word.charAt(wordIdx))
                return false;
                
            int sCharRepeated = countRepeatedChar(s, sIdx);
            int wordCharRepeated = countRepeatedChar(word, wordIdx);

            if ((sCharRepeated != wordCharRepeated) && 
                (sCharRepeated < 3 || (sCharRepeated < wordCharRepeated)))
                return false;

            sIdx += sCharRepeated;
            wordIdx += wordCharRepeated;
        }

        if ((sIdx != s.length()) || (wordIdx != word.length()))
            return false;
            
        return true;
    }

    private int countRepeatedChar(String word, int startIdx) {

        int count = 0;
        int idx = startIdx;
        char c = word.charAt(startIdx);

        while((idx < word.length()) && (c == word.charAt(idx))) {
            count++;
            idx++;
        }

        return count;
    }
}
