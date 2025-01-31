class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        
        int[][] rows = new int[len][len];
        int[][] cols = new int[len][len];
        int[][] squares = new int[len][len];

		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				
				int val = board[i][j] - '1', 
					boxVal = (i / 3) * 3 + j / 3;
				
				if(rows[i][val] == 1 || cols[j][val] == 1 || squares[boxVal][val] == 1) {
					return false;
				}
				
				rows[i][val] = 1;
				
//				if(cols[j][val] == 1) {
//					return false;
//				}
				
				cols[j][val] = 1;
				squares[boxVal][val] = 1;
			}
		}
		
        return true;
    }    
}
