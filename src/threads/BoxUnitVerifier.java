package threads;

import model.SudokuBoard;

import util.UnitChecker;

public class BoxUnitVerifier extends UnitVerifier {

    public BoxUnitVerifier(SudokuBoard board, int boxIndex) {
        super(board, boxIndex);
    }


    @Override
    public void run() {
        if (index == -1) { // -1 checks all rows
            for (int b = 0; b < 9; b++) {
                failures.addAll(UnitChecker.checkBox(b, board));
            }
        } else {
            failures.addAll(UnitChecker.checkBox(index, board));
        }
    }
}

