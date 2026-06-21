class Solution {
    public void sortColors(int[] nums) {
        int freq[]= new int[3];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                freq[0]++;
            }else if(nums[i]==1){
                freq[1]++;
            }else{
                freq[2]++;
            }
        }
        int k=0;
        for(int i=0;i<freq[0];i++){
            nums[k++]=0;
        }
        for(int i=0;i<freq[1];i++){
            nums[k++]=1;
        }
        for(int i=0;i<freq[2];i++){
            nums[k++]=2;
        }
    }
}