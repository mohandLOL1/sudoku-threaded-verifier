package modes;

import model.SudokuBoard;
import threads.*;
import util.FailedVerificationResult;

import java.util.ArrayList;


public class TwentySevenThreadVerificationMode implements VerificationMode {


    @Override
    public void verify(SudokuBoard board) {

        ArrayList<UnitVerifier> threads = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            threads.add(new RowUnitVerifier(board, i));
            threads.add(new ColumnUnitVerifier(board, i));
            threads.add(new BoxUnitVerifier(board, i));
        }

        for (UnitVerifier t : threads) t.start();
        try {
            for (UnitVerifier t : threads) t.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<FailedVerificationResult> allFailures = new ArrayList<>();
        for (UnitVerifier t : threads) allFailures.addAll(t.getFailures());
        for(FailedVerificationResult failedVerificationResult : allFailures){
            System.out.println(failedVerificationResult);
        }
    }

}
