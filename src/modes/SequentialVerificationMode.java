package modes;

import model.SudokuBoard;
import util.FailedVerificationResult;
import util.UnitChecker;

import java.util.ArrayList;

public class SequentialVerificationMode implements VerificationMode{


    @Override
    public void verify(SudokuBoard board) {

        ArrayList<FailedVerificationResult> allFailures = new ArrayList<>();

            for (int i = 0; i < 9; i++) {
                allFailures.addAll(UnitChecker.checkRow(i, board));
            }



            for (int i = 0; i < 9; i++) {
                allFailures.addAll(UnitChecker.checkColumn(i, board));
            }



            for (int i = 0; i < 9; i++) {
                allFailures.addAll(UnitChecker.checkBox(i, board));
            }

            if(allFailures.isEmpty())
                System.out.println("VALID Sudoku solution.");
            else{
                System.out.println("INVALID Sudoku solution.");
                allFailures.forEach(System.out::println);
            }

        }
}
