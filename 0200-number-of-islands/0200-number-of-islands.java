class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int result=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    bfs(m,n,i,j,grid,vis);
                    result++;
                }
            }
        }
        return result;

    }
    public void bfs(int m,int n, int i,int j,char[][] grid,boolean[][] vis){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        vis[i][j]=true;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        while(!queue.isEmpty()){
            int[] current=queue.remove();
            int nr=current[0];
            int nc=current[1];
            for(int k=0;k<4;k++){
                int nnr=nr+dx[k];
                int nnc=nc+dy[k];

                if(nnr>=0 && nnc<n &&  nnr<m && nnc>=0 && grid[nnr][nnc]=='1' && !vis[nnr][nnc]){
                    queue.add(new int[]{nnr,nnc});
                    vis[nnr][nnc]=true;
                }
                
            }
        }
    }
}