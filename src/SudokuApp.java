import model.SudokuBoard;
import modes.SequentialVerificationMode;
import modes.ThreeThreadVerificationMode;
import modes.TwentySevenThreadVerificationMode;

import java.io.IOException;

public class SudokuApp {
    public static void main(String[] args) throws IOException {
        SudokuBoard board = SudokuBoard.fromCSV("resources/board.csv");
        long startTime = System.currentTimeMillis();
        TwentySevenThreadVerificationMode verificationMode = new TwentySevenThreadVerificationMode();
        verificationMode.verify(board);
        long endTime = System.currentTimeMillis();

        System.out.println("Verification took: " + (endTime - startTime) + " ms");

    }
}
