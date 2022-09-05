class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        Long result = Long.valueOf(0);

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                result += min;
            }

        }

        result = result % (long) (Math.pow(10, 9) + 7);

        return result.intValue();
    }
}
