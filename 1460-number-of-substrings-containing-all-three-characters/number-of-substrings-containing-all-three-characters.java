class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int[] freq={-1,-1,-1};
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']=i;
            if(freq[0]>=0 && freq[1]>=0 && freq[2]>=0){
                int m = Math.min(freq[0], Math.min(freq[1], freq[2]));
                count+=m+1;
            }

            
        }
        return count;
    }
}