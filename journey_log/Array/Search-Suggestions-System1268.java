import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();

        // Sort products in lexicographical order
        Arrays.sort(products);

        StringBuilder typed = new StringBuilder("");

        for (int i = 0; i < searchWord.length(); i++) {
            typed.append(String.valueOf(searchWord.charAt(i)));

            List<String> suggestion = new ArrayList<>();
            int count = 0;


            for (String prod : products) {
                if (isPrefix(typed.toString(), prod)) {
                    suggestion.add(prod);
                    count++;
                }

                if (count == 3) 
                    break;
            }
            
            result.add(suggestion);
        }

        return result;
    }

    private boolean isPrefix(String prefix, String word) {

        if (prefix.length() > word.length())
            return false;

        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i))
                return false;
        }

        return true;
    }
}
