import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        int uniqueVal = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != uniqueVal) {
                nums[pointer] = nums[i];
                uniqueVal = nums[i];
                pointer++;
            } else {

            }
        }

        return pointer;
    }
}