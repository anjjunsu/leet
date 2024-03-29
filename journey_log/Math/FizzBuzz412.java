import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            String s = "";

            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0)
                    s += "Fizz";
                
                if (i % 5 == 0)
                    s += "Buzz";                    
            } else {
                s += String.valueOf(i);
            }
            
            result.add(s);  
        }

        return result;
    }
}