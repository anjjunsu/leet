
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int i = 0;
        int j = 0;

        while ((i < word.length()) && (j < abbr.length())) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (Character.isDigit(abbr.charAt(j))) {
                int currDigit = Character.getNumericValue(abbr.charAt(j));

                // check if leading zero
                if (currDigit == 0) 
                    return false;

                StringBuilder numToSkip = new StringBuilder(Integer.toString(currDigit));

                j++;

                while (((j) < abbr.length()) && (Character.isDigit(abbr.charAt(j)))) {
                    numToSkip.append(abbr.charAt(j));
                    j++;
                }

                i += Integer.parseInt(numToSkip.toString());

                continue;
            }

            if (word.charAt(i) != abbr.charAt(j))
                return false;
        }

        if ((i != word.length()) || (j != abbr.length())) 
            return false;

        return true;
    }
}
