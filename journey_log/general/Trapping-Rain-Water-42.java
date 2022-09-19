// Recursion + Memoization
class Solution {
    public int trap(int[] height) {
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int trapped = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trapped;
    }
}


// // Recursive Solution
// class Solution {
//     public int trap(int[] height) {
        
//         int trapped = 0;
//         int leftMax = 0;

//         for (int i = 0; i < height.length; i++) {
//             leftMax = Math.max(leftMax, height[i]);

//             int rightMax = height[i];
//             for (int j = i + 1; j < height.length; j++) {
//                 rightMax = Math.max(rightMax, height[j]);
//             }

//             trapped += Math.min(leftMax, rightMax) - height[i];
//         }

//         return trapped;
//     }
// }
