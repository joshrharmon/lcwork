// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1] k = 3
class Solution {
    public int longestOnes(int[] nums, int k) {
        int fast,
			slow = 0;

            for(fast = 0; fast < nums.length; fast++) {
				if(nums[fast] == 0) {
					k--;
				}
				
				if(k < 0) {
					if(nums[slow] == 0) {
						k++;
					}
					slow++;
				}
			}

        return fast - slow;
    }
}