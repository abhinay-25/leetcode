class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index=candidates.length-1;
        
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        helper(index,target,result,candidates,temp);
        return result;
    }
    public void helper(int index ,int target, List<List<Integer>> result,int[] candidates,List<Integer> temp){
        
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        else if(index<0){
            return ;
        }
        if(candidates[index]<=target){
            
            temp.add(candidates[index]);

            helper(index,target-candidates[index],result,candidates,temp);
            temp.remove(temp.size() - 1);  

        }
       helper(index-1,target,result,candidates,temp);

    }
}