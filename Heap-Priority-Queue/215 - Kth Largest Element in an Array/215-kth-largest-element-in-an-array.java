class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> arr = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            arr.offer(nums[i]);
        }
        for(int j = 1; j < k; j++) {
            arr.poll();
        }
        return arr.peek();
    }
}