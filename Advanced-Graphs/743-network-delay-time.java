class Solution {
	// src -> [dst, travelTime]
	Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
	
	public void dijkstra(int[] sigTimes, int beginSigNode, int len) {
		
		// time, node
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparing(Pair::getKey));
		pq.add(new Pair(0, beginSigNode));
		
		sigTimes[beginSigNode] = 0;
		
		while(!pq.isEmpty()) {
			Pair<Integer, Integer> topPair = pq.remove();
			
			int curNode = topPair.getValue();
			int curTime = topPair.getKey();
			
			// If time it takes to get to the node is longer than the last recorded time, just skip
			if(curTime > sigTimes[curNode]) {
				continue;
			}
			
			if (!adj.containsKey(curNode)) {
                continue;
            }
			
			// Send signal to neighbors of current node
			for(Pair<Integer, Integer> edge : adj.get(curNode)) {
				int neighbor = edge.getValue();
				int time = edge.getKey();
				
				// If time it takes to get to neighbor + current time is less than the last recorded amount
				// of time to get there, then set that as the new lowest time and add the neighbor and that
				// record time to the priority queue
				if(time + curTime < sigTimes[neighbor]) {
					sigTimes[neighbor] = time + curTime;
					pq.add(new Pair(sigTimes[neighbor], neighbor));
				}
			}
		}
	}
	
	public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
		for(int[] time : times) {
			int srcNode = time[0],
				dstNode = time[1],
				sigLen = time[2];
			
			adj.putIfAbsent(srcNode, new ArrayList<>()); // If absent, add source and new arrList to store dest nodes and time
			adj.get(srcNode).add(new Pair(sigLen, dstNode)); // Add new dest node and time to get there
		}
		
		int[] finalSigTimes = new int[n + 1];
		Arrays.fill(finalSigTimes, Integer.MAX_VALUE);
		
		// Begin dijkstra alg 
		dijkstra(finalSigTimes, k, n);
		
		// Find longest signal. If -1 still there, then not all nodes were reached
		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, finalSigTimes[i]);
		}
		
		return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}