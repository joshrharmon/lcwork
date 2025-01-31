class Solution {
    public int coinChange(int[] coins, int amount) {
        int amtRequired = 0;
		Arrays.sort(coins); // sort coins to make iterating faster
		
		for(int i = 0; i < coins.length(); i++) {
			int divisionTimes = amount/coins[i]
			if(divisionTimes < 0) {
				continue;
			}
			else {
				amtRequired += divisionTimes;
				amount -= (coins[i] * divisionTimes);
			}
		}
		
		return amount == 0 ? amtRequired : -1;
    }
}