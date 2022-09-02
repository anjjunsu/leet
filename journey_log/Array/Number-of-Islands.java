//// BFS Approach
class Solution {
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                if (grid[i][j] == '1') {
                    int ID = (i * col) + j;
                    Queue<Integer> adjQ = new LinkedList<>();
                    adjQ.add(ID);
                    numIslands++;

                    while(!adjQ.isEmpty()) {
                        int currID = adjQ.poll();
                        int currRow = currID / col;
                        int currCol = currID % col;

                        // grid[currRow][currCol] = '0'; 

                        if ((currRow + 1 < row) && (grid[currRow+1][currCol] == '1')) {
                            adjQ.add(((currRow+1) * col) + currCol);
                            grid[currRow+1][currCol] = '0';
                        }
                            
                        if ((currRow - 1 >= 0) && (grid[currRow-1][currCol] == '1')) {
                            adjQ.add(((currRow-1) * col) + currCol);
                            grid[currRow-1][currCol] = '0';
                        }
                        if ((currCol + 1 < col) && (grid[currRow][currCol+1] == '1')) {
                            adjQ.add((currRow * col) + currCol+1);
                            grid[currRow][currCol+1] = '0';
                        }
                        if ((currCol - 1 >= 0) && (grid[currRow][currCol-1] == '1')) {
                            adjQ.add((currRow * col) + currCol-1);
                            grid[currRow][currCol-1] = '0';
                        }
                    }  
                }
            }
        }

        return numIslands;
    }
}


//// DFS Approach
// class Solution {
//     public int numIslands(char[][] grid) {
        
//         int numIslands = 0;
//         int row = grid.length;
//         int col = grid[0].length;

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {

//                 if (grid[i][j] == '1') {
//                     numIslands++;
//                     dfsCountIsland(grid, i, j);
//                 }
//             }
//         }

//         return numIslands;
//     }

//     private void dfsCountIsland(char[][] grid, int row, int col) {

//         if ((row < 0) || (row >= grid.length) || (col < 0) || (col >= grid[0].length))
//             return;

//         if (grid[row][col] == '0')
//             return;

//         if (grid[row][col] == '1')
//             grid[row][col] = '0';
        
//         dfsCountIsland(grid, row+1, col);
//         dfsCountIsland(grid, row-1, col);
//         dfsCountIsland(grid, row, col+1);
//         dfsCountIsland(grid, row, col-1);
//     }
// }
