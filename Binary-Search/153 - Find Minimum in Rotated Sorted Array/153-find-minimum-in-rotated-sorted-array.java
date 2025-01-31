/**
 *	[6,7,0,1,2,4,5]
 * 	[2,4,5,6,7,0,1]
 * 	[7,0,1,2,4,5,6]
 *  [11,13,15,17]
 *	[2,3,4,5,1]
 *  [5,4,3,2,1]
 *  [1,2]
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        else {
            int left = 0, right = nums.length - 1;
            while(left <= right) {
            	int mid = (right + left) / 2;
            	if(nums[mid] > nums[mid + 1]) {
            		return nums[mid + 1];
            	}
            	else if(nums[mid] < nums[mid - 1]) {
            		return nums[mid];
            	}
            	else if(nums[mid] > nums[0]) {
            		left = mid + 1;
            	}
            	else if(nums[mid] < nums[0]) {
            		right = mid - 1;
            	}
            }
        }
        return -1;
    }
}
