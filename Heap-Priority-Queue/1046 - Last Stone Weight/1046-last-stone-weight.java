import java.util.Comparator;
import java.util.PriorityQueue;
 
class Solution {
    
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> sortedStones = new PriorityQueue<Integer>(stones.length, Comparator.reverseOrder());

		// Load into PriorityQueue
		for(int i : stones) {
			sortedStones.add(i);
		}
		
		// Process if more than one stone
		if(stones.length > 1) {
			while(sortedStones.size() > 1) {
				int rock1 = sortedStones.poll(), rock2 = sortedStones.poll();
				if(rock1 > rock2) {
					sortedStones.add(rock1 - rock2);
				}
				else if(rock2 > rock1) {
					sortedStones.add(rock2 - rock1);
				}
			}
		}
		return sortedStones.isEmpty() ? 0 : sortedStones.peek();
    }
}