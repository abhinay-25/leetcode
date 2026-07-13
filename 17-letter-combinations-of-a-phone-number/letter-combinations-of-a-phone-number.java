class Solution {
    private String[] digitmappings={"" ,"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
       
        List<String> combinations=new ArrayList<>();
        helper(combinations,digits,"",0);
        return combinations;

    }
    void helper(List<String> combinations,String digits,String cur,int index){
        if(index==digits.length()){
            combinations.add(cur);
            return ;
        }
        String letters=digitmappings[digits.charAt(index)-'0'];
        for(char ch:letters.toCharArray()){
            helper(combinations,digits,cur+ch,index+1);
        }

    }
}