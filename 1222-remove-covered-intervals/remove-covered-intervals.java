class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
            return Integer.compare(b[1], a[1]);
            }       
            return Integer.compare(a[0], b[0]);
        });
        int m=intervals.length;
        int n=2;
        int count=0;
        if(m==1){
            return 1;
        }
        int i=0;
        int j=1;
        while(j<=m-1){
            if(intervals[i][1]>=intervals[j][1]){
                count++;
                
            }else{
                i=j;
            }
            j++;
        }
        return m-count;

    }
}