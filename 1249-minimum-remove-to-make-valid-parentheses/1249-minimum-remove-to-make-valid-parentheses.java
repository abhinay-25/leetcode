class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(ch);
                str.append(ch);

            }else if(ch==')' && !stack.isEmpty()){
                stack.pop();
                str.append(ch);
                
            }else if(Character.isLowerCase(ch)){
                str.append(ch);
            }else{
                continue;
            }
        }
        int i=str.length()-1;
        while(!stack.isEmpty() ){
            if(i>=0){char ch=str.charAt(i);
            if(ch=='('){
                stack.pop();
                str.deleteCharAt(i);
                

            }
            i--;
            }
            
        }
        return str.toString();
    }
}