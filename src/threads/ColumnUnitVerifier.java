package threads;

import model.SudokuBoard;

import util.UnitChecker;

public class ColumnUnitVerifier extends UnitVerifier {

    public ColumnUnitVerifier(SudokuBoard board, int col) {
        super(board, col);
    }

    @Override
    public void run() {
        if (index == -1) { // -1 checks all rows
            for (int c = 0; c < 9; c++) {
                failures.addAll(UnitChecker.checkColumn(c, board));
            }
        } else {
            failures.addAll(UnitChecker.checkColumn(index, board));
        }
    }
}

