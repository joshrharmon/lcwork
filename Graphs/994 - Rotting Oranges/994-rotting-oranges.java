class Solution {
    public int orangesRotting(int[][] grid) {
        int orangesLeft = 0, steps = -1, rowLen = grid.length, colLen = grid[0].length;
		Queue<Pair<Integer, Integer>> q = new ArrayDeque();
		
		// Count amount of rotten/fresh oranges
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(grid[i][j] == 2) {
					q.offer(new Pair(i, j));
				}
				if(grid[i][j] == 1) {
					orangesLeft++;
				}
			}
		}
		
		q.offer(new Pair(-1, -1));
		int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while(!q.isEmpty()) {
			Pair<Integer, Integer> p = q.poll();
			int row = p.getKey(), col = p.getValue();
			
			if(row == -1) {
				steps++;
				if(!q.isEmpty()) {
					q.offer(new Pair(-1, -1));
				}
			} else {
				for(int[] d : directions) {
					int rowNeigh = row + d[0], colNeigh = col + d[1];
					if(rowNeigh >= 0 && rowNeigh < rowLen && colNeigh >= 0 && colNeigh < colLen) {
						if(grid[rowNeigh][colNeigh] == 1) {
							grid[rowNeigh][colNeigh] = 2;
							orangesLeft--;
							q.offer(new Pair(rowNeigh, colNeigh));
						}
					}
				}
			}
		}
		return orangesLeft == 0 ? steps : -1;
    }
}