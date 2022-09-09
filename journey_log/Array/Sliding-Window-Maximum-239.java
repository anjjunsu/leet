import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            while (right < left + k) {
                while (!dq.isEmpty() && nums[right] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.addLast(right);
                right++;
            }

            if (left > dq.peekFirst()) {
                dq.pollFirst();
            }
            left++;

            result.add(nums[dq.peekFirst()]);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
