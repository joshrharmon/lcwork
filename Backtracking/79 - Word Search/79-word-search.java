class Solution {
    public boolean exist(char[][] board, String word) {
        int cur = 0;
        boolean found = false;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
            	HashSet<ArrayList<Integer>> visited = new HashSet<>();
                if(board[i][j] == word.charAt(0))
                {
                	found = search(board, i, j, word, cur, visited);
                }
            }
        }
        return found;
    }
    
    public boolean search(char[][] board, int row, int col, String word, int index, HashSet<ArrayList<Integer>> visited)
    {
        visited.add(new ArrayList<>(Arrays.asList(row, col)));
        
        // Current cell == last char and index at end? Return true
        if(index == word.length() - 1 && board[row][col] == word.charAt(word.length() - 1))
        {
        	return true;
        }
        else if((row + 1 < board.length && col + 1 < board[0].length && row - 1 >= 0 && col - 1 >= 0) || )
        {
        	return false;
        }
        else 
        {
        	// Down
		    if(row + 1 < board.length && !visited.contains(new ArrayList<>(Arrays.asList(row + 1, col))) && board[row + 1][col] == word.charAt(++index))
		    {
		    	search(board, row + 1, col, word, ++index);
		    }
		    // Right
		    if(col + 1 < board[0].length && !visited.contains(new ArrayList<>(Arrays.asList(row, col + 1))) && board[row][col + 1] == word.charAt(++index))
		    {
		    	search(board, row, col + 1, word, ++index);
		    }
		    // Up
		    if(row - 1 >= 0 && !visited.contains(new ArrayList<>(Arrays.asList(row - 1, col))) && board[row - 1][col] == word.charAt(++index))
		    {
		    	search(board, row - 1, col, word, ++index);
		    }
		    // Left
		    if(col - 1 >= 0 && !visited.contains(new ArrayList<>(Arrays.asList(row, col - 1))) && board[row][col - 1] == word.charAt(++index))
		    {
		    	search(board, row, col - 1, word, ++index);
		    }
        }
    }
}
