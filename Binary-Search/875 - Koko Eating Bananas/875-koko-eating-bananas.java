class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lP = 1, rP = 1;
        
        // Find max value
        for(int i : piles)
        {
        	rP = Math.max(rP, i);
        }
        
        while(lP < rP)
        {
			int mid = (lP + rP) / 2, hourSpent = 0;
			
			for(int pile : piles) 
			{
				hourSpent += Math.ceil((double) pile / mid);
			}
			
			if(hourSpent <= h)
			{
				rP = mid;
			}
			else
			{
				lP = mid + 1;
			}
        }
        
        return rP;
    }
}
