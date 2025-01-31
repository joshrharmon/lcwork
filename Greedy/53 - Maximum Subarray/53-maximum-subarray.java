/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE, curSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            curSum += nums[i];
            largestSum = Math.max(largestSum, curSum);
            if(curSum < 0)
                curSum = 0;
        }
        return largestSum;
    }
}
