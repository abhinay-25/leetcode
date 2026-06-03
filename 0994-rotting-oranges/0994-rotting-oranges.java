class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 2: BFS
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if(rotted) time++;
        }

        return fresh == 0 ? time : -1;
    }
}