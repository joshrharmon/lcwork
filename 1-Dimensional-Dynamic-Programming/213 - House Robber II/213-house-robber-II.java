/*
 * [ 7, 4, 1, 9, 3, 8, 6, 5]
 *   .     .     .     .    -> 17
 *      .     .     .     . -> 26
 * [ 7, 7, 8, 16, 16, 24, ]
 */

class Solution {
    public int rob(int[] nums) 
    {
        int maxRob;
        int[] houses = new int[nums.length];
        
        if(nums.length == 1)
        {
            return nums[0];
        }
        else if(nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        else
        {
			return Math.max(robRecur(nums, 0, nums.length - 1), robRecur(nums, 1, nums.length));
        }
    }
    
    public int robRecur(int[] nums, int start, int end)
    {
    	int[] dp = new int[nums.length];
    	
    	dp[0] = nums[0];
    	dp[1] = Math.max(nums[0], nums[1]);
    	
    	for(int i = 2; i < dp.length; i++)
    	{
    		dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    	}
    	
    	return dp[dp.length - 1];
    }
}
