// zaaabbbbcccc
// 

class Solution {
    public int compress(char[] chars) {
        int amt = 1, curindex = 0;
		if(chars.length == 1) {
			return 1;
		}
		else {
			for(int i = 0; i < chars.length; i++) {
				if((chars[i] != chars[i + 1]) || (chars[i] == chars.length - 1)) {
					if(amt == 1) {
						continue;
					}
					else {
						
					}
					amt = 1;
					curindex = i + 1;
				}
				else {
					amt++
				}
			}
		}
		return chars.length;
    }
}