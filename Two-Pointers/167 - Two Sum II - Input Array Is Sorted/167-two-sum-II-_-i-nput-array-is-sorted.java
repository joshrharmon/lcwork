class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int leftP = 0, rightP = numbers.length - 1;
        while(leftP < rightP) {
        	if(numbers[leftP] + numbers[rightP] == target) {
        		ans[0] = leftP + 1;
        		ans[1] = rightP + 1;
        		break;
        	}
        	else if(numbers[leftP] + numbers[rightP] > target) {
        		rightP--;
        	}
        	else if(numbers[leftP] + numbers[rightP] < target) {
        		leftP++;
        	}
        }
        return ans;
    }
}
