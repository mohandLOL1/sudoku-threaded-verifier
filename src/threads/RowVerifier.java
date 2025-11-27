package threads;

public class RowVerifier implements ThreadVerifier {

    private final int[][] board;
    private final int num;
    private final int row; 
    
    public RowVerifier(int[][] board, int num, int row) {

        this.board = board;
        this.row = row;
        this.num = num;
    }
    
    
    @Override
    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
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
