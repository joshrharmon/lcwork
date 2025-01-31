/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int midPoint = ((nums1.length + nums2.length) / 2) + 1,
            n1Point = 0,
            n2Point = 0;
        boolean isOdd = (nums1.length + nums2.length) % 2 == 0 ? false : true;
        ArrayList<Integer> sorted = new ArrayList<>();
        if(nums1.length == 1 && nums2.length == 0)
        {
            return nums1[0];
        }
        else if(nums2.length == 1 && nums1.length == 0)
        {
            return nums2[0];
        }
        else if(nums1.length == 0 && nums2.length == 0)
        {
            return 0.0;
        }
        else
        {
            while(sorted.size() < midPoint)
            {
                if(n1Point > nums1.length - 1)
                {
                    sorted.add(nums2[n2Point]);
                    n2Point++;
                }
                else if(n2Point > nums2.length - 1)
                {
                    sorted.add(nums1[n1Point]);
                    n1Point++;
                }
                else if(nums1[n1Point] < nums2[n2Point])
                {
                    sorted.add(nums1[n1Point]);
                    n1Point++;
                }
                else if(nums1[n1Point] > nums2[n2Point])
                {
                    sorted.add(nums2[n2Point]);
                    n2Point++;
                }
                else 
                {
                    if(sorted.size() + 2 > midPoint)
                    {
                        sorted.add(nums1[n1Point]);
                        n1Point++;
                    }
                    else
                    {
                        sorted.add(nums1[n1Point]);
                        sorted.add(nums2[n2Point]);
                        n1Point++;
                        n2Point++;
                    }
                    
                }
            }
            ans = isOdd ? (sorted.get(sorted.size() - 1)) : (sorted.get(sorted.size() - 1) + sorted.get(sorted.size() - 2)) / 2.0;   
        }
        return ans;
    }
}
