class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        List<int[]>res=new ArrayList<>();
        while(i < intervals.length &&
      intervals[i][1] < newInterval[0]) {

    res.add(intervals[i]);
    i++;
}
        while(i<intervals.length && (intervals[i][1]>=newInterval[0] &&newInterval[1]>=intervals[i][0])){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
             newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i=i+1;
        }
        res.add(newInterval);
        while(i<intervals.length){
            res.add(intervals[i]);
            i=i+1;
        }
        int[][]ans=new int[res.size()][2];
        for(int j=0;j<res.size();j=j+1){
            ans[j]=res.get(j);
        }
        return ans;
    }
}