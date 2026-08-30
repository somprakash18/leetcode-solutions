class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals,(a,b)->{
                int val= Integer.compare(a[0],b[0]);
               return val==0?Integer.compare(b[1],a[1]):val;
                });
            int count=1;
            int maxEnd=intervals[0][1];
            for(int i=1;i<intervals.length;i=i+1){
               if(intervals[i][1]>maxEnd){
                count=count+1;
                maxEnd=intervals[i][1];
               }
            }
            return count;
    }
}