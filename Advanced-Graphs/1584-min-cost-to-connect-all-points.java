class Solution {
	public int minCostConnectPoints(int[][] points) {
        int size = points.length, mstCost = 0, edgesUsed = 0;
		PriorityQueue<Pair<Integer, Integer>> nodeWeights = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> Integer.compare(a.getValue(), b.getValue())); // [node, weight]
		boolean[] nodesSeen = new boolean[size];
		
		nodeWeights.add(new Pair(0, 0));
		
		while(edgesUsed < size) {
			Pair<Integer, Integer> top = nodeWeights.poll();
			int node = top.getKey(), weight = top.getValue();
			
			if(nodesSeen[node]) {
				continue;
			}
			
			nodesSeen[node] = true;
			mstCost += weight;
			edgesUsed++;
			
			// Make connections to other nodes
			for(int i = 0; i < size; i++) {
				if(!nodesSeen[i]) {
					int nextWeight = Math.abs(points[i][0] - points[node][0]) 
						+ Math.abs(points[i][1] - points[node][1]);
					nodeWeights.add(new Pair(i, nextWeight));
				}
			}
		}
		return mstCost;
    }
}