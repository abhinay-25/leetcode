class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] distance = new int[m][n];
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }

        if(m == 1 && n == 1){
            return 1;
        }

        for(int i = 0; i < m; i++){
                Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q=new LinkedList<>();
         q.add(new int[]{1,0,0});      
        distance[0][0] = 1;    
        while(!q.isEmpty()){         
            int ans = check(grid,distance,q);
            if(ans != -1){
                return ans;
            }
        }
        return -1;
    }
    public int check (int[][] grid,int[][] distance,Queue<int[]> q){
        int m=grid.length;
        int n=grid[0].length;
        int[] temp=q.remove();
        
        int row=temp[1];
        int col=temp[2];
        int[][] direction={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int[] dir:direction){
            int nrow=row+dir[0];
            int ncol=col+dir[1];
            if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && grid[nrow][ncol]==0){
                if(distance[row][col]+1<distance[nrow][ncol]){
                    distance[nrow][ncol]=distance[row][col]+1;

                if(nrow==m-1 && ncol==n-1){
                     return distance[nrow][ncol];
                }

                q.add(new int[]{distance[nrow][ncol],nrow,ncol});
                }
                if(nrow==m-1 && ncol==n-1){
                    return distance[nrow][ncol];
                }
                
            }
        }
        return -1;
    }
}