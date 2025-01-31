/*
 * [73,74,75,71,69,72,76,73]
 * [0, 0, 0, 0, 0, 1, 0, 0]
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length, hottest = 0;
        int[] answer = new int[len];
        
        if(len > 1) {
        	for(int i = len - 1; i >= 0; i--) {
		    	if(temperatures[i] >= hottest) {
		    		hottest = temperatures[i];
		    		continue;
		    	}
		    	
		    	int days = 1;
		    	while(temperatures[i + days] <= temperatures[i]) {
		    		days += answer[i + days];
		    	}
		    	answer[i] = days;
		    }
        }
        return answer;
    }
}
