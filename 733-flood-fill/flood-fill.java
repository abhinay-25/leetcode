class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];
        if(original == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        image[sr][sc] = color;

        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == original){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}