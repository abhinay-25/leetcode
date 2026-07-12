class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,result,used,new ArrayList<>());
        return result;
    }
    void helper(int[] nums,List<List<Integer>> result,boolean[]  used,List<Integer> curr){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                curr.add(nums[i]);
                helper(nums,result,used,curr);
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}