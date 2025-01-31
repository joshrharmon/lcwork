class Solution {
    public int search(int[] nums, int target) {
    	int lP = 0, rP = nums.length - 1;
		while(lP < rP) {
			int mid = lP + (rP - lP) / 2;
			if(nums[mid] >= target) {
				rP = mid;
			} else {
                lP = mid + 1;
			}
		}
        
        if(lP < nums.length && nums[lP] == target) {
            return lP;
        } else {
            return -1;
        }    
    }
}
