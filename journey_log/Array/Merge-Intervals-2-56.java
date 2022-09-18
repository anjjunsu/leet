import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> merged = new ArrayList<>();
        
        Arrays.sort(intervals, new intervalComparator());
        
        for(int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[0] = Math.min(merged.get(merged.size() - 1)[0], interval[0]);
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }

    class intervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] i1, int[] i2) {

            return i1[0] - i2[0];
        }


    }
}