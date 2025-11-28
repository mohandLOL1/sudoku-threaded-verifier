package modes;

import model.SudokuBoard;

import threads.RowVerifier;
import threads.ColumnVerifier;
import threads.BoxVerifier;

public class ThreeThreadVerificationMode implements VerificationMode{


    @Override
    public void verify(SudokuBoard board) {
        
        RowVerifier rowVerifier =new RowVerifier();
        ColumnVerifier columnVerifier=new ColumnVerifier();
        BoxVerifier boxVerifier=new BoxVerifier();
     
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
    }
}
