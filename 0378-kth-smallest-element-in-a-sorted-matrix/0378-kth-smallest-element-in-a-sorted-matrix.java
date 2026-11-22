class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int s=matrix[0][0];
        int e=matrix[n-1][n-1];
        while(s<e){ 
             int m=s+(e-s)/2;
             int count=0;
             for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]<=m){
                        count++;
                    }
                }
             }
             if(count<k){
                s=m+1;
             }else{
                e=m;
             }
        }
        return s;
    }
}