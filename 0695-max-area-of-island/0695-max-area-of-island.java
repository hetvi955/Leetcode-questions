class Solution {

    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        int r= grid.length;
        int c= grid[0].length;

        int maxArea=0;

        seen= new boolean[r][c];

       for(int row=0; row<r; row++){
        for(int col=0; col<c; col++){
            if(grid[row][col]==1){
                int currArea= area( grid, row, col);
                maxArea=Math.max(maxArea, currArea);
            }
           
        }
       }

       return maxArea;

    }

        public int area(int[][] grid, int r, int c){
            if(r<0 || r>=grid.length ||  c<0 || c>=grid[0].length || seen[r][c] || grid[r][c]==0 ){
                return 0;
            } 

            seen[r][c]= true;
            return 1 + (area(grid, r+1, c) + area(grid, r-1, c) + area(grid, r, c-1) + area(grid, r, c+1));


            
        }


    
}