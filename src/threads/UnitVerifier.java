package threads;

import model.SudokuBoard;
import util.FailedVerificationResult;
import java.util.ArrayList;

public abstract class UnitVerifier extends Thread {

    protected SudokuBoard board;
    protected int index; // which row/col/box this thread checks
    protected ArrayList<FailedVerificationResult> failures;

    public UnitVerifier(SudokuBoard board, int index) {
        this.board = board;
        this.index = index;
        this.failures = new ArrayList<>();
    }

    public ArrayList<FailedVerificationResult> getFailures() {
        return failures;
    }
}