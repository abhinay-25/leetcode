class Solution {
    public int largestAltitude(int[] gain) {
        int[] alt=new int[gain.length+1];
        alt[0]=0;
        for(int i=1;i<alt.length;i++){
            alt[i]=gain[i-1]+alt[i-1];
        }
        int max = Integer.MIN_VALUE;

for(int num : alt){
    max = Math.max(max, num);
}

return max;
            
        
    }
}