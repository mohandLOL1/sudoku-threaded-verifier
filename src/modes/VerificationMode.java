package modes;

import model.SudokuBoard;
import util.FailedVerificationResult;

import java.util.ArrayList;


public interface VerificationMode {
    public abstract ArrayList<FailedVerificationResult> verify(SudokuBoard board);
}
