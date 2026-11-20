class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rs=mat.length;
        int cs=mat[0].length;
        int s=0;
        int e=rs-1;
        while(s<=e){
            int r=s+(e-s)/2;
            int c=0;
            for(int j=1;j<cs;j++){
                if(mat[r][j]>mat[r][c]){
                    c=j;
                }
            }
            int up=(r>0)?mat[r-1][c]:-1;
            int down=(r<rs-1)?mat[r+1][c]:-1;
            if(mat[r][c]>up &&mat[r][c]>down){
                return new int[]{r,c};
            }
            else if(up>mat[r][c]){
                e=r-1;
            }
            else{
                s=r+1;
            }
        }
        return new int[]{-1,-1};

    }
}