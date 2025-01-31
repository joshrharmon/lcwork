/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        for(int row = 0; row < matrix.length; row++)
        {
            for(int col = 0; col < matrix[0].length; col++)
            {
                if(matrix[row][col] == 0)
                {
                    if(row == 0) firstRowZero = true;
                    if(col == 0) firstColZero = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;       
                }
            }
        }
        for(int rowCheck = 1; rowCheck < matrix.length; rowCheck++)
        {
            for(int colCheck = 1; colCheck < matrix[0].length; colCheck++)
            {
                if(matrix[rowCheck][0] == 0 || matrix[0][colCheck] == 0)
                {
                    matrix[rowCheck][colCheck] = 0;
                }
            }
        }
        if(firstRowZero)
        {
           Arrays.fill(matrix[0], 0);
        }
        if(firstColZero)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
