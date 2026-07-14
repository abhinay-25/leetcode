class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int sum=0;
        helper(candidates.length-1,result,new ArrayList<>(),sum,target,candidates);
        return result;
    }
    void helper(int index,List<List<Integer>> result,List<Integer> curr,int sum,int target ,int[] candidates){
        
        if(index<0){
            if(sum==target){
            result.add(new ArrayList<>(curr));
            }
            return ;
        }
        if(sum<target){
            curr.add(candidates[index]);
            helper(index,result,curr,sum+candidates[index],target,candidates);
            curr.remove(curr.size()-1);
        }
         helper(index-1,result,curr,sum,target,candidates);
    }
}