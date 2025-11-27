package modes;

import model.SudokuBoard;
import util.UnitVerificationResult;

public interface VerificationMode {
    public abstract void verify(SudokuBoard board);
}
