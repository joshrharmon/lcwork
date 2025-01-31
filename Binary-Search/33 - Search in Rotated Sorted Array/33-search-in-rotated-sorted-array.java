/*
 * (looking for 6)
 * [4,5,6,7,0,1,2]
 *  l     m     r
 *  l m r
 *      lmr
 * [6,7,0,1,2,3,4]
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
            while(left <= right) {
            	int mid = (right + left) / 2;
            	if(nums[mid] == target) {
            		return mid;
            	}
            	else if(nums[mid] >= nums[0]) {
            		if(target >= nums[0] && target < nums[mid]) {
            			right = mid - 1;
            		} else {
            			left = mid + 1;
            		}
            	} 
            	else {
            		if(target > nums[mid] && target <= nums[nums.length - 1]) {
            			left = mid + 1;
            		} else {
            			right = mid - 1;
            		}
            	}
            }
        return -1;
    }
}
