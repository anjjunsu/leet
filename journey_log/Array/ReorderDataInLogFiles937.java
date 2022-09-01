import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new LogComparator());

        return logs;
    }
}

class LogComparator implements Comparator<String> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(String o1, String o2) {
        
        String[] o1Arr = o1.split(" ", 2);
        String[] o2Arr = o2.split(" ", 2);
        
        Boolean isO1DigitLog = Character.isDigit(o1Arr[1].charAt(0));
        Boolean isO2DigitLog = Character.isDigit(o2Arr[1].charAt(0));
        
        if (isO1DigitLog && isO2DigitLog) {
            // both digit log
            return 0;
        } if (!isO1DigitLog && !isO2DigitLog) {
            // both letter log
            int cmp = o1Arr[1].compareTo(o2Arr[1]);

            if (cmp != 0)
                return cmp;

            return o1Arr[0].compareTo(o2Arr[0]);
        } else {
            if (isO1DigitLog) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
