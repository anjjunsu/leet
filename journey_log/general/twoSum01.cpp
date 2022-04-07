class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int, int> diff_map;

        for (int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];

            if (diff_map.find(diff) != diff_map.end()) {
                // key found
                result.push_back(diff_map[diff]);
                result.push_back(i);
                return result;
            } else {
                // key not found => insert to map   
                diff_map[nums[i]] = i;
            }
        }

        // this part should not be reached (problem invaraint)
        // throw error
        throw invalid_argument("invalid problem");
    }
};