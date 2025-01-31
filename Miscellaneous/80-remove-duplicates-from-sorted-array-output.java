// removeDuplicatesFromSortedArrayOutput
// [1,1,1,2,2,3] -> [1,1,2,2,3,_,_]

class Solution {
	public int removeDuplicates(int[] nums) {
        int lazy = 1, 
			fast = 1,
			curAmt = 1;
		while(fast < nums.length) {
			if(nums[fast] == nums[fast - 1]) {
				curAmt++;
				if(curAmt > 2) {
					fast++;
					continue;
				}
			}
			else {
				curAmt = 1;
			}
			nums[lazy] = nums[fast];
			fast++;
			lazy++;
		}
		return lazy;
	}
}
