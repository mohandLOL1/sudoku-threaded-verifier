package modes;

import model.SudokuBoard;


public interface VerificationMode {
    public abstract void verify(SudokuBoard board);
}
