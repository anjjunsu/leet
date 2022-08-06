import java.util.ArrayList;
import java.util.List;

class Solution {
    public int myAtoi(String s) {
        int result = 0;
        Boolean positive = true;
        Boolean numStarted = false;
        Boolean numEnded = false;

        List<Character> storage = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // Leading space handler
            if (currChar == ' ' && !numStarted) {
                continue;
            }
            
            // Sign handler
            if ((currChar == '+' || currChar == '-') && !numStarted) {
                if (currChar == '-')
                    positive = false;
                
                numStarted = true;
                continue;
            } 

            // Leading zero handler
            if (currChar == '0' && !numStarted) {
                numStarted = true;
                continue;
            }

            // Zero after sign handler
            if (currChar == '0' && storage.size() == 0) {
                continue;
            }

            // First number handler
            if (IsDigit(currChar) && !numEnded) {
                numStarted = true;
                storage.add((Character) currChar);
                continue;
            }

            // Number handler
            if (numStarted && !numEnded && IsDigit(currChar)) {
                storage.add((Character) currChar);
                continue;
            }

            // Decimal handler
            if (numStarted && !numEnded && currChar == '.') {
                return ListToInt(storage, positive);
            }

            // After number handler
            if (!IsDigit(currChar)) {
                numEnded = true;
                continue;
            }

            // Number after numEnded handler
            if (numEnded && IsDigit(currChar)) {
                continue;
            }
        }        

        return ListToInt(storage, positive);
    }

    private int ListToInt(List<Character> list, Boolean isPostive) {
        long result = 0;
        double multiplier = Math.pow(10, list.size() - 1);
        for (Character c : list) {
            result += CharToInt(c) * multiplier;
            multiplier /= 10;
        }
        
        if (!isPostive) {
            result *= -1;
            if (result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    private Boolean IsDigit(char c) {
        List<Character> digits = List.of(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');  

        return digits.contains((Character) c);
    }

    private int CharToInt(Character c) {
        List<Character> digits = List.of(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');  

        return digits.indexOf(c);
    }
}