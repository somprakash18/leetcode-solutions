class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rs=matrix.length;
        int cs=matrix[0].length;
        int s=0;
        int e=rs*cs-1;
        while(s<=e){
            int m=s+(e-s)/2;
            int r=m/cs;
            int c=m%cs;
            if(matrix[r][c]==target){
                return true;
            }
            else if(matrix[r][c]<target){
                s=m+1;
            }
            else{
                e=m-1;
            }

    
        }
        return false;
    }
}