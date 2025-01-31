class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, profit = 0;
        if(prices.length > 1)
        {
        	for(int i = 0; i < prices.length; i++)
        	{
        		minPrice = Math.min(minPrice, prices[i]);
        		profit = Math.max(profit, prices[i] - minPrice);
        	}
        }
        return profit;
    }
}
