class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rs=matrix.length;
        int cs=matrix[0].length;
        int r=0;
        int c=cs-1;
        while(r<rs&&c>=0){
            if(target==matrix[r][c]){
                return true;
            }
            else if(target<matrix[r][c]){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
}