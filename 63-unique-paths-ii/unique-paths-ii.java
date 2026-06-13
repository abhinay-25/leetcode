class Solution {
    public int uniquePathsWithObstacles(int[][] result) {
        int m=result.length;
        int n=result[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(result[i][j]==1){
                    result[i][j]=-1;
                }
            }
        }
        if(result[m-1][n-1]==-1 || result[0][0]==-1 ){
            return 0;
        }
        result[0][0] = 1;

// First Row
for(int i=1;i<n;i++){
    if(result[0][i] >= 0){
        if(result[0][i-1] < 0){
            result[0][i] = 0;
        }else{
            result[0][i] = result[0][i-1];
        }
    }
}

// First Column
for(int i=1;i<m;i++){
    if(result[i][0] >= 0){
        if(result[i-1][0] < 0){
            result[i][0] = 0;
        }else{
            result[i][0] = result[i-1][0];
        }
    }
}
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(result[i][j]<0){
                    continue;
                }
                else{
                    if(result[i][j-1]<0){
                        result[i][j]=result[i-1][j];
                    }else if(result[i-1][j]<0){
                        result[i][j]=result[i][j-1];
                    }else{
                        result[i][j]=result[i][j-1]+result[i-1][j];
                    }
                    
                }
                
            }
        }
        return result[m-1][n-1] == -1 ? 0 : result[m-1][n-1];
    }
}