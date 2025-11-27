package threads;

public class ColumnVerifier implements ThreadVerifier {

    private final int[][] board;
    private final int num;
    private final int col; 
    
    public ColumnVerifier(int[][] board, int num, int col) {

        this.board = board;
        this.col = col;
        this.num = num;

    }
    
    @Override
    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }
    
    
    @Override
    public void run(){
     isValid();
    }
}
