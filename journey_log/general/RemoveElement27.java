class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) 
        {
            if (nums[left] == val) 
            {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right--;
            }
            else {
                left++;
            }
        }
        return left;
    }
}