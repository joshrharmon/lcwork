/* 
     *                       * => 1 * 8 = 8
        *                    * => 7 * 7 = 49 MAX
        *                 *    => 3 * 6 = 18
        *              *       => 8 * 5 = 40
           *           *       => 6 * 4 = 24
              *        *       => 2 * 3 = 6
                 *     *       => 5 * 2 = 10
                    *  *       => 4 * 1 = 4
                       *       => DONE
 *  [1, 8, 6, 2, 5, 4, 8, 3, 7]
 *   *                   *  => 2 * 6 	= 12
 *      *                *  => 3 * 5 	= 15
 *         *             *  => 4 * 4 	= 16
 *            *          *  => 5 * 3 	= 15
                  *      *  => 6 * 2 	= 12
                  *   *     => 17 * 1	= 17
 *  [2, 3, 4, 5, 18, 17, 6]
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, leftP = 0, rightP = height.length - 1;
        while(leftP < rightP) {
        	maxArea = Math.max(maxArea, (Math.min(height[leftP], height[rightP])) * (rightP - leftP));
        	if(height[leftP] > height[rightP])
        		rightP--;
        	else if(height[leftP] <= height[rightP])
        		leftP++;
        }
        return maxArea;
    }
}
