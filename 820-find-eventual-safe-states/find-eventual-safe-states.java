class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] vis= new boolean[n];
        boolean[] path=new boolean[n];
        boolean[] safe=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                check(i,graph,vis,path,safe);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i] == true) safeNodes.add(i);
        }
 
        return safeNodes;

    }
    public boolean check(int node,int[][] graph ,boolean[] vis,boolean[] path ,boolean[] safe){
        vis[node] = true; 
        path[node] = true;  

        for(int neighbor:graph[node]){
            if(vis[neighbor]==false){
                if(check(neighbor ,graph,vis,path,safe)){
                    return true;
                }
            }else if(path[neighbor]==true){
                return true;
            }
        }
        safe[node]=true;
        path[node]=false;
        return false;
    }
}