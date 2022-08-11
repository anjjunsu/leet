class Solution {
public:
    int singleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        
        for (auto it = nums.begin() + 1; it < nums.end(); it = it + 2) {
            if (*(it - 1) != *it)
                return *(it - 1);
        }
        
        return *(nums.end() - 1);
    }
};