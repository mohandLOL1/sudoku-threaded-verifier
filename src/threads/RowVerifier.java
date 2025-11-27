package threads;
import model.SudokuBoard;

public class RowVerifier implements ThreadVerifier {
    
    private SudokuBoard board;
    private boolean valid = true;


    
    public RowVerifier(SudokuBoard board) {

        this.board = board;
    }
    
    

    
    @Override
    public void run(){
        for (int i = 0; i < 9; i++) {
            int[] row = board.getRow(i);

            if (!isvalid_num(row)) {
                System.out.println("Invalid row at index: " + i);

                valid = false;
                break;
            }
    }
  }
    
    @Override
    public boolean isValid() {
       return valid;
    }
    
    public boolean isvalid_num(int[] arr) {

        boolean[] n = new boolean[10];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num < 1 || num > 9) {
                return false;
            }
            if (n[num]) {
                return false;
            }
            n[num] = true;
        }
        return true;
    }


}
