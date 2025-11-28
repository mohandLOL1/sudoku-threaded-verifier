import model.SudokuBoard;
import modes.*;

import java.io.IOException;

public class SudokuApp {
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Usage: java -jar <appname>.jar <csvPath> <mode>");
            return;
        }

        String csvPath = args[0];
        String modeName = args[1];

        SudokuBoard board = SudokuBoard.fromCSV(csvPath);
        try {
            VerificationMode mode = VerificationModeFactory.getMode(modeName);
            long start = System.nanoTime();
            mode.verify(board);
            long end = System.nanoTime();

            System.out.printf("Verification took %.3f ms%n", (end - start) / 1_000_000.0);
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid mode of verifications, please choose either: sequential, 3-threaded or 27-threaded");
        }
    }
}

