/*
 * [-1, 0, 1, 2, -1, -4] - Sort -> [-4, -1, -1, 0, 1, 2]
 *
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                int leftP = i + 1, rightP = nums.length - 1;
                Set<Integer> seen = new HashSet<>();
                for(int j = i + 1; j < nums.length; ++j) {
                	int complement = -nums[i] - nums[j];
                	if(seen.contains(complement)) {
                		sums.add(Arrays.asList(nums[i], nums[j], complement));
                		while(j + 1 < nums.length && nums[j] == nums[j + 1]) {
                			++j;
                		}
                	}
                	seen.add(nums[j]);
                }  
            }
        }
        return sums;
    }
}
