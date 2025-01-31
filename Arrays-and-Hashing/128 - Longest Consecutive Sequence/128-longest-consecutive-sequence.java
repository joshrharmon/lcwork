/*
 * 100, 4, 200, 1, 3, 2
 * Iterate through the list and load it into a hashset.
 * Then iterate once more, this time if when checking an element, you find that there is not the element - 1, this is the start of a sequence of at least length 1 (itself). Initiate a while loop that checks to see if an element + 1 exists and continue checking, keeping track of how many you get. Return the longest amount.
 * 
 */
 
class Solution {
    public int longestConsecutive(int[] nums) {
   		HashSet<Integer> numList = new HashSet<>();
		int longest = 0;
		if(nums.length > 0) {
			for(int i : nums) {
   				numList.add(i);
   			}
   			
   			for(int j : numList) {
   				if(!numList.contains(j - 1)) {
   					int temp = 0;
   					while(numList.contains(j + temp)) {
   						temp++;
   					}
   					longest = Math.max(longest, temp);
   				}
   			}
		}
   		return longest;
    }
}
