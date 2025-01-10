package hexgameoflife;

/**
 *
 * @author Wiktoria Kalata 20057
 */
public class GameLogic {
    
    /**
    * Computes the next state of the game board based on the rules of the Game of Life.
    *
    * @param board The current state of the game board.
    * @param survivalNum The number of living neighbors required for a cell to survive to the next generation.
    * @param birthNum The number of living neighbors required for a new cell to be born.
    * @return The updated game board representing the next state.
    */
    public static int[][] computeNextState(int[][] board, int survivalNum, int birthNum){
        int size = board.length;
        int[][] new_board = new int[size][size];
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board.length; y++){
                updateCellStatus(x,y, board, new_board, survivalNum, birthNum);
            }
        }
        return new_board;
    }
    
    /**
    * Updates the status of a cell based on its neighbors and the rules of the Game of Life.
    *
    * @param x The x-coordinate of the cell.
    * @param y The y-coordinate of the cell.
    * @param board The current state of the game board.
    * @param survivalNum The number of living neighbors required for a cell to survive to the next generation.
    * @param birthNum The number of living neighbors required for a new cell to be born.
    */
    private static void updateCellStatus(int x, int y, int[][] board, int[][] new_board, int survivalNum, int birthNum){
        int aliveNeighborhood = aliveNeighborCellsNum(x, y, board);
        if(isCellAlive(x, y, board)){
            if(aliveNeighborhood == survivalNum) new_board[x][y] =1; else new_board[x][y]= -1;
        }else{
            if(aliveNeighborhood == birthNum) new_board[x][y] =2; else new_board[x][y]=0;
        } 
    }
    
    
    /**
    * Prepares the next generation of the game board based on the specified rules:
    * - Converts any cell with a value of -1 (representing a cell that died in the previous generation) to 0.
    * - Converts any cell with a value of 2 (representing a cell that was born from the previous generation) to 1.
    *
    * @param board The current state of the game board.
    * @return The next generation of the game board after applying the specified rules.
    */
    public static int[][] prepareNextGeneration(int[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j]==-1) board[i][j]=0; 
                else if(board[i][j]==2) board[i][j]=1;
            }
        }
        return board;
    }
    
    /**
    * Generates the neighborhood of a cell based on its coordinates.
    *
    * @param x The x-coordinate of the cell.
    * @param y The y-coordinate of the cell.
    * @return The array representing the neighborhood coordinates.
    */
    private static int[][] generateNeighborhood(int x, int y){
        int[][] neighborhood;
        if(x%2!=0){
            neighborhood= new int[][]{
            {x, y-1},
            {x+1,  y},
            {x+1,  y+1},
            {x,  y+1},
            {x-1,  y+1},
            {x-1,  y},
            };
        }else{
            neighborhood= new int[][]{
            {x, y-1},
            {x+1,  y-1},
            {x+1,  y},
            {x,  y+1},
            {x-1,  y},
            {x-1,  y-1},
            };
        }
        return neighborhood;
    }
    
    /**
    * Counts the number of alive neighbor cells for a given cell.
    *
    * @param x The x-coordinate of the cell.
    * @param y The y-coordinate of the cell.
    * @param board The current state of the game board.
    * @return The number of alive neighbor cells.
    */
    private static int aliveNeighborCellsNum(int x, int y, int[][] board){
        int aliveNeighborCells = 0;
        int[][] neighborhood = generateNeighborhood(x, y);
        for (int[] cell : neighborhood) {
            try {
                if (isCellAlive(cell[0], cell[1], board)) {
                    aliveNeighborCells++;
                }
            }catch(Exception e){}
        }
        return aliveNeighborCells;
    }
     
    /**
    * Checks if a cell is alive based on its coordinates.
    *
    * @param x The x-coordinate of the cell.
    * @param y The y-coordinate of the cell.
    * @param board The current state of the game board.
    * @return True if the cell is alive, false otherwise.
    */
    private static boolean isCellAlive(int x, int y, int[][] board){
        return board[x][y]==1;
    }   
}
