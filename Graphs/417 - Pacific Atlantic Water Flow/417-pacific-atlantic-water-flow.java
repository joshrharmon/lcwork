class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
 		if(heights.length == 0 || heights[0].length == 0)
 		{
 			return new ArrayList<>();
 		}
 		
 		numRows = heights.length;
 		numCols = heights[0].length;
 		landHeights = heights;
 		boolean[][] pacificReach = new boolean[numRows][numCols];
 		boolean[][] atlanticReach = new boolean[numRows][numCols];
 		
 		// Iterate through the right and left cells
 		for(int i = 0; i < numRows; i++)
 		{
 			dfs(i, 0, pacificReach);
 			dfs(i, numCols - 1, atlanticReach);
 		}
 		
 		// Iterate through the top and bottom cells
 		for(int i = 0; i < numCols; i++)
 		{
 			dfs(0, i, pacificReach);
 			dfs(numRows - 1, i, atlanticReach);
 		}
 		
 		List<List<Integer>> common = new ArrayList<>();
 		for(int i = 0; i < numRows; i++)
 		{
 			for(int j = 0; j < numCols; j++)
 			{
 				if(pacificReach[i][j] && atlanticReach[i][j])
 				{
 					common.add(List.of(i, j));
 				}
 			}
 		}
 		return common;
    }
    
    public void dfs(int row, int col, boolean[][] land)
    {
    	land[row][col] = true;
    	for(int[] dir : DIRECTIONS)
    	{
    		int newRow = row + dir[0], newCol = col + dir[1];
    		
    		// Check that direction is within bounds. 
    		if(newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols)
    		{
    			continue;
    		}
    		
    		// Check if it has already been visited
    		if(land[newRow][newCol])
    		{
    			continue;
    		}
    		
    		// See if the new row/col is greater than the old. This will check for if the new is lesser and if it is, then it's not reachable, thus continue and skip. 
    		if(landHeights[newRow][newCol] < landHeights[row][col])
    		{
    			continue;
    		}
    		
    		dfs(newRow, newCol, land);
    	}
    }
}
