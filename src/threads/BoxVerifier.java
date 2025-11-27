package threads;

public class BoxVerifier implements ThreadVerifier {
   
    private final int[][] board;
    private final int num;
    private final int row;
    private final int col;
    
    public BoxVerifier(int[][]board,int num,int row, int col){
    
    this.board=board;
    this.num=num;
    this.row=row;
    this.col=col;
    }
    
    @Override
    public boolean isValid() {
        int local_row = row - row % 3;
        int local_col = col - col % 3;
        for (int i = local_row; i < local_row + 3; i++) {
            for (int j = local_col; j < local_col + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public void run(){
        isValid();
    }


}
