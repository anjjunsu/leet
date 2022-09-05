import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        PriorityQueue<Integer> alloc = 
            new PriorityQueue<>(
                intervals.length, 
                new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i1 - i2;
                    }
                });
            
        Arrays.sort(intervals, 
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

        alloc.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (alloc.peek() <= intervals[i][0]) {
                alloc.poll();
            }

            alloc.add(intervals[i][1]);
        }

        return alloc.size();                                     
    }
}
