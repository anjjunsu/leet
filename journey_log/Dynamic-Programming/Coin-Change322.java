// Dynamic Programming - Top down
class Solution {

    Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        
        memo = new Integer[amount+1];

        return recursiveHelper(coins, amount);
    }

    private int recursiveHelper(int[] coins, int remain) {

        if (remain == 0)
            return 0;

        if (remain < 0)
            return -1;

        if (memo[remain] != null) 
            return memo[remain];

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin > remain)
                continue;
            
            int count = recursiveHelper(coins, remain-coin);

            if (count != -1) {
                minCount = Math.min(count+1, minCount);
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            memo[remain] = -1;
            return -1;
        }
                   
        memo[remain] = minCount;

        return minCount;
    }
}

// // Dynamic Programming - Bottom up 
// class Solution {
//     public int coinChange(int[] coins, int amount) {

//         Integer[] dp = new Integer[amount+1];

//         Arrays.fill(dp, amount+1);

//         dp[0] = 0;

//         for (int i = 1; i <= amount; i++) {
//             for (int coin : coins) {
//                 if (coin > i) 
//                     continue;

//                 dp[i] = Math.min(dp[i-coin]+1, dp[i]);
//             }
//         }

//         return dp[amount] > amount ? -1 : dp[amount];
//     } 
// }