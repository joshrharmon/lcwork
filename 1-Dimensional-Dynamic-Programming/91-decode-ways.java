/*
 * 1344
 * 1 3 4 4 /
 * 13 4 4 /
 * 1 34 4 x
 * 1 3 44 x
 * 13 44 x
 */
class Solution {
    public int numDecodings(String s) {
        int ways = 0;
        int slen = s.length();

        if(slen == 1) {
            ways = isValid(s) ? 1 : 0;
        }
        else {
            
        }

        return ways;
    }

    public boolean isValid(String s) {
        int cur = Integer.parseInt(s.substring(0, 1));
        return (cur >= 1 && cur <= 26);
    }
}