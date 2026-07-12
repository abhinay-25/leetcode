class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res=new HashSet<>();
        helper(nums.length-1,nums,res,new ArrayList<>());
        List<List<Integer>> result=new ArrayList<>(res);
        return result;
    }
    void helper(int index,int[] nums,Set<List<Integer>> res,List<Integer> cur){
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