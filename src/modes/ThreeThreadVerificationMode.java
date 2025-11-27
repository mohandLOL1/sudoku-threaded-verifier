package modes;

import model.SudokuBoard;

import threads.RowVerifier;
import threads.ColumnVerifier;
import threads.BoxVerifier;

public class ThreeThreadVerificationMode implements VerificationMode{


    @Override
    public void verify(SudokuBoard board) {
        
        RowVerifier rowVerifier =new RowVerifier(board);
        ColumnVerifier columnVerifier=new ColumnVerifier(board);
        BoxVerifier boxVerifier=new BoxVerifier(board);
     
        Thread t1 = new Thread(rowVerifier);
        Thread t2 = new Thread(columnVerifier);
        Thread t3 = new Thread(boxVerifier);
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      boolean valid =rowVerifier.isValid() &&columnVerifier.isValid() &&boxVerifier.isValid();
      
        if (valid) {
            System.out.println("Sudoku board is VALID.");
        } else {
            System.out.println("Sudoku board is INVALID.");
        }
    }
}
