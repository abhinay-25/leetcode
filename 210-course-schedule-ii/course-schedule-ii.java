import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            for(int j = 1; j < 2; j++){
                adj.get(prerequisites[i][j]).add(prerequisites[i][j - 1]);
            }
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == false){
                if(dfs(i, st, adj, vis, pathVis)){
                    return new int[0]; // cycle found
                }
            }
        }

        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            result[i] = st.peek();
            st.pop();
        }

        return result;
    }

    public boolean dfs(int node,
                       Stack<Integer> st,
                       List<List<Integer>> adj,
                       boolean[] vis,
                       boolean[] pathVis){

        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour : adj.get(node)){

            if(vis[neighbour] == false){

                if(dfs(neighbour, st, adj, vis, pathVis)){
                    return true;
                }

            }else if(pathVis[neighbour]){

                return true; // cycle detected
            }
        }

        pathVis[node] = false;
        st.push(node);

        return false;
    }
}