package threads;

import model.SudokuBoard;
import util.UnitChecker;

public class RowUnitVerifier extends UnitVerifier {

    public RowUnitVerifier(SudokuBoard board, int row) {
        super(board, row);
    }


    @Override
    public void run() {

        if (index == -1) { // -1 checks all rows
            for (int r = 0; r < 9; r++) {
                failures.addAll(UnitChecker.checkRow(r, board));
                }
            } else {
                failures.addAll(UnitChecker.checkRow(index, board));
            }
        }
}