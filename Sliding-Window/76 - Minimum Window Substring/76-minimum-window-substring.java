class Solution {
    public String minWindow(String s, String t) {
		int lp = 0, rp = 0, lpMinWin = 0, rpMinWin = 0;
		HashMap<String, Integer> substringMap = new HashMap<String, Integer>();
		HashMap<String, Integer> windowMap = new HashMap<String, Integer>();
			
		if(t.length() > s.length()) {
			return "";
		}
		else {
			// Load substring HashMap with each letter and count of letter
			for(int i = 0; i < t.length(); i++) {
				String l = t.substring(i, i + 1);
				substringMap.put(l, substringMap.getOrDefault(l, 0) + 1);
			}
			
			// boolean which changes to true when all chars of t are in s
			boolean condsMet = false;
			
			// While the right pointer has not reached the end of the longer string, continue
			while(rp < s.length()) {
				
				// Try to add new substring to windowMap
				String temp = s.substring(rp, rp + 1);
				windowMap.put(temp, windowMap.getOrDefault(temp, 0) + 1);
				
				// See if conditions are met
				condsMet = checkWin(substringMap, windowMap);
				
				// If all chars of substring are present, then try to shrink window
				if(condsMet) {
					
					// Try to contract window while keeping conditions
					while(condsMet && lp < rp) {
						String temp1 = s.substring(lp, lp + 1);
						windowMap.put(temp1, windowMap.get(temp1) - 1);
						lp++;
						condsMet = checkWin(substringMap, windowMap);
					}
					
					// Update minwin lp and rp if the pointer distance is less
					if(rp - lp < rpMinWin - lpMinWin) {
						rpMinWin = rp;
						lpMinWin = lp;
					}
				}
				else {
					rp++;
				}
			}
		}
		return s.substring(lpMinWin, rpMinWin + 1);
    }
	
	// Checks that all distinct counts of chars are present in string
	public boolean checkWin(HashMap<String, Integer> sub, HashMap<String, Integer> win) {
		for(String s : sub.keySet()) {
			if(win.get(s) != sub.get(s)) {
				return false;
			}
		}
		return true;
	}
}