class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words=s.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=words.length-1;i>0;i--){
            String str=words[i];
            if(!str.trim().isEmpty()){
                result.append(str + " ");
            }
            
        }
        if(!words[0].trim().isEmpty()){
            result.append(words[0]);
        } 
        return result.toString();

        
    }
}