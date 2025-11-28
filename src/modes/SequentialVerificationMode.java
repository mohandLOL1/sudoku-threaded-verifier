package modes;

import model.SudokuBoard;
import util.FailedVerificationResult;
import util.UnitChecker;

public class SequentialVerificationMode implements VerificationMode{


    @Override
    public void verify(SudokuBoard board) {

            for (int i = 0; i < 9; i++) {
                for (FailedVerificationResult verificationResult : UnitChecker.checkRow(i, board)) {
                    System.out.println(verificationResult);
                }
            }

            System.out.println("-----------------------------------");

            for (int i = 0; i < 9; i++) {
                for (FailedVerificationResult verificationResult : UnitChecker.checkColumn(i, board)) {
                    System.out.println(verificationResult);
                }
            }

           System.out.println("-----------------------------------");

            for (int i = 0; i < 9; i++) {
                for (FailedVerificationResult verificationResult : UnitChecker.checkBox(i, board)) {
                    System.out.println(verificationResult);
                }
            }

        }
}
