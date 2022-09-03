// class Solution {

//     Integer[] memo;
//     public int coinChange(int[] coins, int amount) {
        
//         memo = new Integer[amount+1];

//         return recursionHelper(coins, amount);
//     }

//     private int recursionHelper(int[] coins, int remain) {

//         if (remain < 0) 
//             return -1;
        
//         if (remain == 0) 
//             return 0;
        
//         if (memo[remain] != null) 
//             return memo[remain];
        
//         int minCount = Integer.MAX_VALUE;

//         for (int c : coins) {
//             int count = recursionHelper(coins, remain - c);
//             if (count < 0) 
//                 continue;

//             minCount = Math.min(minCount, count + 1);
//         }

//         memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        
//         return memo[remain];
//     }
// }
