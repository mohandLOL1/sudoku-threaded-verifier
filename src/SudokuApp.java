import model.SudokuBoard;
import modes.*;
import util.FailedVerificationResult;

import java.io.IOException;
import java.util.ArrayList;

public class SudokuApp {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java -jar <appname>.jar <csvPath> <mode>");
            return;
        }

        String csvPath = args[0];
        String modeName = args[1];

        try {
            SudokuBoard board = SudokuBoard.fromCSV(csvPath); // could throw IOException
            VerificationMode mode = VerificationModeFactory.getMode(modeName); // could throw IllegalArgumentException

            long start = System.nanoTime();

            ArrayList<FailedVerificationResult> failures = mode.verify(board);

            long end = System.nanoTime();

            displayFailuresInCLI(failures);

            System.out.printf("Verification took %.3f ms%n", (end - start) / 1_000_000.0);
        } catch (IOException e) {
            System.out.println("Error: Could not read CSV file at " + csvPath);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid mode of verification, please choose either: sequential, 3-threaded, or 27-threaded");
        }
    }

    private static void displayFailuresInCLI(ArrayList<FailedVerificationResult> failures) {
        if(failures.isEmpty()){
            System.out.println("VALID SUDOKU BOARD");
        }
        else{
            for(FailedVerificationResult failedVerificationResult : failures){
                System.out.println(failedVerificationResult);
            }
        }

    }
}

