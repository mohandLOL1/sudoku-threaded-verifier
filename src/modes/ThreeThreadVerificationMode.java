package modes;

import model.SudokuBoard;

import threads.RowUnitVerifier;
import threads.ColumnUnitVerifier;
import threads.BoxUnitVerifier;
import util.FailedVerificationResult;

import java.util.ArrayList;

public class ThreeThreadVerificationMode implements VerificationMode{


    @Override
    public void verify(SudokuBoard board){

        RowUnitVerifier rowThread = new RowUnitVerifier(board, -1); // -1 means all rows
        ColumnUnitVerifier colThread = new ColumnUnitVerifier(board, -1);
        BoxUnitVerifier boxThread = new BoxUnitVerifier(board, -1);

        rowThread.start();
        colThread.start();
        boxThread.start();

        try {
            rowThread.join();
            colThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<FailedVerificationResult> allFailures = new ArrayList<>();
        allFailures.addAll(rowThread.getFailures());
        allFailures.addAll(colThread.getFailures());
        allFailures.addAll(boxThread.getFailures());

        for(FailedVerificationResult verificationResult : allFailures){
            System.out.println(verificationResult);
        }
    }
}
