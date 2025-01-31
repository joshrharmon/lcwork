/*
 *  *                     * => r = 0
 *    *                   * => lMax = 1, rMax = 0, l = 1, r = 1, ans = 0
 *    *                 *   => lMax = 1, rMax = 1, l = 1, r = 2, ans = 0
 *      *               *   => lMax = 1, rMax = 1, l = 0, r = 2, ans = 1
 *        *             *   => lMax = 2, rMax = 1, l = 2, r = 2, ans = 1
 *        *           *		=> lMax = 2, rMax = 2, l = 2, r = 1, ans = 2
 *        *         *       => lMax = 2, rMax = 2, l = 2, r = 2, ans = 2
 *        *       *         => lMax = 2, rMax = 2, l = 2, r = 3, ans = 2
 *          *     *         => lMax = 2, rMax = 2, l = 1, r = 3, ans = 3
 *            *   *         => lMax = 2, rMax = 2, l = 0, r = 3, ans = 5
 *              * *         => lMax = 2, rMax = 2, l = 1, r = 3, ans = 6
 * [0,1,0,2,1,0,1,3,2,1,2,1]
 *
 * *              * => r = 0
 *    *           * => lMax = 4, rMax = 0, l = 2, r = 5, ans = 0
 *       *        * => lMax = 4, rMax = 0, l = 0, r = 5, ans = 2
 *          *     * => lMax = 4, rMax = 0, l = 3, r = 5, ans = 6
 *             *  * => lMax = 4, rMax = 0, l = 2, r = 5, ans = 7
 *                * => lMax = 4, rMax = 0, l = 5, r = 5, ans = 9
 *                .
 * .              .
 * .        .     .
 * .  .     .  .  .
 * .  .     .  .  .
 *[4, 2, 0, 3, 2, 5]
 */

class Solution {
    public int trap(int[] height) {
        int ans = 0, lPoint = 0, rPoint = height.length - 1, lMax = 0, rMax = 0;
        if(height.length > 2) {
        	while(lPoint < rPoint) {
        		if(height[lPoint] < height[rPoint]) {
                    if(height[lPoint] > lMax) {
                        lMax = height[lPoint];
                    } else {
                        ans += lMax - height[lPoint];
                    }
                    lPoint++;
                } else {
                    if(height[rPoint] > rMax){
                        rMax = height[rPoint];   
                    } else {
                        ans += rMax - height[rPoint];   
                    }
                    rPoint--;
                }
        	}
        } else {
        	return 0;
        }
        return ans;
    }
}
