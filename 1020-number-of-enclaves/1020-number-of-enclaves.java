class Solution {
    public int numEnclaves(int[][] board) {
        int r=board.length;
        int c=board[0].length;
        int result=0;
        boolean[][] vis=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1 && vis[i][j] ==false && (i == 0 || i == r - 1 || j == 0 || j == c - 1)){
                    vis[i][j]=true;
                    bfs(i,j,board,vis);
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1 && vis[i][j]==false){
                    result++;
                }
            }
        }
        return result;
    }
     public void bfs(int i,int j,int[][] board ,boolean[][] vis){
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] removed=q.remove();
            int r=removed[0];
            int c=removed[1];
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc]==false && board[nr][nc]==1){
                    vis[nr][nc] =true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        
    }
}