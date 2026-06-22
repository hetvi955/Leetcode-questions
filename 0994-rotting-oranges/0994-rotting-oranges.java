class Solution {
    public int orangesRotting(int[][] grid) {
        int r=grid.length, c=grid[0].length;


        Queue<int[]> q= new LinkedList<>();
        int fresh=0, minutes=0;

        //count all fresh and add all rotten to the q
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }

        }

        int[][] dirs={{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!q.isEmpty() && fresh>0){
            minutes++;
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] cell=q.poll();
                for(int[] d:dirs){
                    int row= cell[0] + d[0];
                    int col= cell[1] + d[1];

                    if(row<0 || row>=r || col<0 || col>=c) continue;
                    if(grid[row][col]!=1) continue;
                    grid[row][col]=2;
                    fresh--;
                    q.add(new int[]{row, col});
                }
            }

        }

        return fresh==0 ? minutes :-1;


    }
}