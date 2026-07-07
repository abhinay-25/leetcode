class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n =temperatures.length;
        int[] result=new int[n];
        
        
        Stack<Integer> stack=new Stack<>();
        result[n-1]=0;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            
           
            while(!stack.isEmpty()){
                if(temperatures[i]<temperatures[stack.peek()]){
                    
                    
                    result[i]=stack.peek()-i;
                    break;
                    
                    
                }else{
                    stack.pop();
                    
                    
                    
                    
                }
            }
            if(stack.isEmpty()){
                result[i]=0;
            }
            
            
            stack.push(i);
        }
        return result;
    }
}