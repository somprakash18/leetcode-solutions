class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s=0;
        int e=matrix.length*matrix[0].length-1;
        while(s<=e){
            int m=s+(e-s)/2;
             int row = m / matrix[0].length;
            int col = m % matrix[0].length;
            if(target==matrix[row][col]){
                return true;
            }else if(target<matrix[row][col]){
                e=m-1;
            }else {
                s=m+1;
            }
        }
        return false;

    }
}