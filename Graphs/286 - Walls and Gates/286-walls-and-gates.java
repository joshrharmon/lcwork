/*
 *  -1 : wall/obstacle
 *   0 : gate
 *   INF : empty
 *
 * - | g 1
 * - - 1 |
 * - | - |
 * g | - -
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
		Queue<Pair<Integer, Integer>> q = new ArrayDeque();
		int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int maxRow = rooms.length, maxCol = rooms[0].length, inf = Integer.MAX_VALUE;
		
		// find gates
		for(int i = 0; i < maxRow; i++) {
			for(int j = 0; j < maxCol; j++) {
				if(rooms[i][j] == 0) {
					q.offer(new Pair(i, j));
				}
			}
		}
		
		// run BFS
		while(!q.isEmpty()) {
			Pair<Integer, Integer> p = q.poll();
			for(int[] d : directions) {
				int row = p.getKey(), col = p.getValue(), rowNeigh = row + d[0], colNeigh = col + d[1];
				if(rowNeigh >= 0 && rowNeigh < maxRow && colNeigh >= 0 && colNeigh < maxCol) {
					if(rooms[rowNeigh][colNeigh] == inf) {
						q.offer(new Pair(rowNeigh, colNeigh));
						rooms[rowNeigh][colNeigh] = rooms[row][col] + 1;
					}
				}
			}
		}
    }
}
