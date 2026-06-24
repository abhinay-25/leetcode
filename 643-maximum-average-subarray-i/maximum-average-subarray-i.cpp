class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double curr  =0;
        int p=0;
        int j=k;
        for(int i=0;i<k;i++){
            curr+=nums[i];
        }
        double max=curr;
        
        while(j<nums.size()){
            curr=curr-nums[p]+nums[j];
            if(curr>max){
                max=curr;
            }
            p++;
            j++;
        }
        return max/k;

        
    }
};