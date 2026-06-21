class Solution {
    public int maxIceCream(int[] costs, int coins) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(costs);
        if(costs[0]>coins){
            return 0;
        }
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                list.add(costs[i]);
                coins-=costs[i];
            }
            else{
                break;
            }
        }
        return list.size();
    }
    
}