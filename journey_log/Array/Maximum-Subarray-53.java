// O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        
        int prevSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (prevSum < 0) {
                prevSum = nums[i];
            } else {
                prevSum += nums[i];
            }

            maxSum = Math.max(maxSum, prevSum);
        }

        return maxSum;
    }
}

// // Brute Force: O(n^2)
// class Solution {
//     public int maxSubArray(int[] nums) {
        
//         int maxSum = Integer.MIN_VALUE;

//         for (int i = 0; i < nums.length; i++) {
//             int sum = 0;

//             for (int j = i; j < nums.length; j++) {
//                 sum += nums[j];
//                 maxSum = Math.max(maxSum, sum);
//             }
//         }

//         return maxSum;
//     }
// }
