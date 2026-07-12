class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums.length-1,nums,res,new ArrayList<>());
        return res;
    }
    void helper(int index,int[] nums,List<List<Integer>> res,List<Integer> cur){
        if(index<0){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(index-1,nums,res,cur);
        cur.remove(cur.size()-1);
        helper(index-1,nums,res,cur);
        
    }
}