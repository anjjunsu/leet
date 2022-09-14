class Solution {
    public int getMaxLen(int[] nums) {
        
        int max = 0;
        int firstNegative = -1;
        int start = -1;
        int negativeCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                if(firstNegative == -1) firstNegative = i;
            } 
            if (nums[i] == 0) {
                start = i;
                negativeCount = 0;
                firstNegative = -1;
            } else if (negativeCount % 2 == 0) {
                max = Math.max(max, i - start);
            } else {
                max = Math.max(max, i - firstNegative);
            }
        }

        return max;
    }
}
