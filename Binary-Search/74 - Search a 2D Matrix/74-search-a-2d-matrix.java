/*
 * [[1,3,5,7],
 	[10,11,16,20],
 	[23,30,34,60]]
 * 
 * [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60]
 *  -				*						-
 *	-           -
 *  	  -  *  -
 *		        -
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, 
        	cols = matrix[0].length,
        	left = 0,
        	right = (rows * cols) - 1;
        	
        if (rows == 0)
            return false;
        	
        while(left <= right) {
			int pivotPl = (left + right) / 2,
                pivotVal = matrix[pivotPl / cols][pivotPl % cols];
        	if(pivotVal == target) {
        		return true;
        	}
        	else if(pivotVal > target) {
        		right = pivotPl - 1;
        	}
        	else {
        		left = pivotPl + 1;
        	}
        }
        return false;
    }
}
