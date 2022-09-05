class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        long minimumHealth = 0;
        int maxDmgIdx = 0;

        for (int i = 0; i < damage.length; i++) {
            // update index of max. damage
            if (damage[i] > damage[maxDmgIdx])
                maxDmgIdx = i;

            minimumHealth += damage[i];
        }

        minimumHealth -= damage[maxDmgIdx]-armor < 0 ? damage[maxDmgIdx] : armor;

        minimumHealth++;    // Need at least 1 health left

        return minimumHealth;
    }
}
