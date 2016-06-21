public class Solution {
    //2 methods:
    //1: DFS when we get a 1, do the dfs to its left, up, right, down, and label all ajacent 1s to 0
    //   we loop through the whole thing, how many searches we did, how many islands there are
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0){
           return 0;
       }
       
       if(grid[0] == null || grid[0].length == 0){
           return 0;
       }
       
       int count = 0;
       for(int i = 0; i < grid.length; i++){
           for(int j = 0; j < grid[0].length; j++){
               if(grid[i][j] == '0'){
                   continue;
               }
               count++;
               setonetozero(i, j, grid);
           }
       }
       
       return count;
        
    }
    
    private void setonetozero(int i, int j, char[][] grid){
        //this is possible: imagine there's a whole 1 line: there'll be a point that pointer exceeds the boundary 
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        
        if(grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        
        if(i > 0){
            setonetozero(i - 1, j, grid);
        }
        
        if(i < grid.length){
            setonetozero(i + 1, j, grid);
        }
        
        if(j > 0){
            setonetozero(i, j - 1, grid);
        }
        
        if(j < grid[0].length){
            setonetozero(i, j + 1, grid);
        }
        
    }
}
