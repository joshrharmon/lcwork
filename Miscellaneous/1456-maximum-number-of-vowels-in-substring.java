/*
 * weallloveyou
 * 1234567
 */

class Solution {
	public int maxVowels(String s, int k) {
		HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int ans = 0,
			cur = 0,
			pLeft = 0,
			sLen = s.length();

		// Search initial window
		for(int i = 0; i < k; i++) {
			if(vowels.contains(s.charAt(i))) {
				cur++;
			}
		}
		
		ans = Math.max(ans, cur);
		
		// Slide window to the end of string
		for(int i = k; i < sLen; i++) {
			if(vowels.contains(s.charAt(i))) {
				cur++;
			}
			if(vowels.contains(s.charAt(pLeft))) {
				cur--;
			}
			pLeft++;
			ans = Math.max(ans, cur);
		}
		return ans;
	}
}