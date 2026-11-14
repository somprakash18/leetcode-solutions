class Solution {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int s=1;
        int e=x;
        int ans=0;
        while(s<=e){
       int m=s+(e-s)/2;
       if((long)m*m<=x){
        ans=m;
        s=m+1;
       } else{
        e=m-1;
       }
        }
       return ans;
    }
}