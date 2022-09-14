// Dynamic programming with contant space
class Solution {
    public int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;
        int sum = first + second;

        for (int i = 3; i <= n; i++) {
            sum = first + second;

            first = second;
            second = sum;
        }

        return sum;
    }
}


// // Dynamic programming 
// class Solution {
//     public int climbStairs(int n) {
        
//         if (n == 1) return 1;
//         if (n == 2) return 2;

//         int[] dp = new int[n + 1];

//         dp[1] = 1;
//         dp[2] = 2;

//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 2] + dp[i - 1];
//         }

//         return dp[n];
//     }
// }

// // Recursion + Memoization
// class Solution {

//     Integer[] memo;

//     public int climbStairs(int n) {
        
//         memo = new Integer[n + 1];

//         return recursiveHelper(n);
//     }

//     private int recursiveHelper(int n) {

//         if (n < 0) return 0;

//         if (n == 0) return 1;

//         if (memo[n] != null) return memo[n];

//         memo[n] = recursiveHelper(n - 1) + recursiveHelper(n - 2);

//         return memo[n];
//     }
// }

// // Recursion
// class Solution {
//     public int climbStairs(int n) {
        
//         return recursiveHelper(n);
//     }

//     private int recursiveHelper(int n) {
        
//         if (n < -1) return 0;

//         if (n == 0) return 1;

//         return recursiveHelper(n - 1) + recursiveHelper(n - 2);
//     }
// }
