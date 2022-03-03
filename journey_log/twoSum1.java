package journey_log;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> diff = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(target - nums[i])) {
                result[0] = diff.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                diff.put(nums[i], i);
            }
        }
        
        return result;
    }
}

