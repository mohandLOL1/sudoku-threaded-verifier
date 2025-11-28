import model.SudokuBoard;
import modes.SequentialVerificationMode;

import java.io.IOException;

public class SudokuApp {
    public static void main(String[] args) throws IOException {
        SudokuBoard board = SudokuBoard.fromCSV("resources/board.csv");
        SequentialVerificationMode verificationMode = new SequentialVerificationMode();
        verificationMode.verify(board);

    }
}
