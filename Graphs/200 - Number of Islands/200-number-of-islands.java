/*
 * Input: grid = [
 *	  	["1","1","1","1","0"],
 *	  	["1","1","0","1","0"],
 *  	["1","1","0","0","0"],
 *	  	["0","0","0","0","0"]
 *	]
 *
 *
 */

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
        	for(int j = 0; j < grid[0].length; j++)
        	{
        		if(!seen[i][j] && grid[i][j] == '1')
        		{
        			numIslands++;
        			recurse(grid, i, j, seen);
        		}
        	}
        }
        return numIslands;
    }
    
    public void recurse(char[][] grid, int row, int col, boolean[][] seen) {

		// If the row or col falls out of bounds of the grid, return
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length)
        {
        	return;
        }   
        
        // If the current cell is 0 or it's been visited, return
	    if(grid[row][col] == '0' || seen[row][col])
	    {
	    	return;
	    }
	    
	    // Mark every connected 1 as seen
	    seen[row][col] = true;
	    
	    // Visit up, down, left, right cells
	    recurse(grid, row - 1, col, seen);
    	recurse(grid, row + 1, col, seen);
   		recurse(grid, row, col - 1, seen);
   		recurse(grid, row, col + 1, seen);
    }
}

