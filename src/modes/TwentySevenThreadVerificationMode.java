package modes;

import model.SudokuBoard;
import threads.*;
import util.FailedVerificationResult;

import java.util.ArrayList;


public class TwentySevenThreadVerificationMode implements VerificationMode {

    @Override

    public ArrayList<FailedVerificationResult> verify(SudokuBoard board) {

        ArrayList<RowUnitVerifier> rowThreads = new ArrayList<>();
        ArrayList<ColumnUnitVerifier> colThreads = new ArrayList<>();
        ArrayList<BoxUnitVerifier> boxThreads = new ArrayList<>();

        // create threads
        for (int i = 0; i < 9; i++) {
            rowThreads.add(new RowUnitVerifier(board, i));
            colThreads.add(new ColumnUnitVerifier(board, i));
            boxThreads.add(new BoxUnitVerifier(board, i));
        }

        // start threads
        rowThreads.forEach(Thread::start);
        colThreads.forEach(Thread::start);
        boxThreads.forEach(Thread::start);

        // join threads
        try {
            rowThreads.forEach(t -> {
                try { t.join(); } catch (InterruptedException e) { throw new RuntimeException(e); }
            });
            colThreads.forEach(t -> {
                try { t.join(); } catch (InterruptedException e) { throw new RuntimeException(e); }
            });
            boxThreads.forEach(t -> {
                try { t.join(); } catch (InterruptedException e) { throw new RuntimeException(e); }
            });
        } catch (RuntimeException e) {
            throw e;
        }

        // collect results
        ArrayList<FailedVerificationResult> allFailures = new ArrayList<>();
        rowThreads.forEach(t -> allFailures.addAll(t.getFailures()));
        colThreads.forEach(t -> allFailures.addAll(t.getFailures()));
        boxThreads.forEach(t -> allFailures.addAll(t.getFailures()));

        return allFailures;
        }
    }





