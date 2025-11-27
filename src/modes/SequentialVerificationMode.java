package modes;

import model.SudokuBoard;

public class SequentialVerificationMode implements VerificationMode{

    @Override
    public void verify(SudokuBoard board) {
        
        boolean valid = true;

        for (int i = 0; i < 9; i++) {
            int[] row = board.getRow(i);

            if (!isvalid_num(row)) {
                System.out.println("Invalid row at index: " + i);

                valid = false;
                break;
            }
        }
    
        for (int i = 0; i < 9 && valid; i++) {
            int[] col = board.getColumn(i);

            if (!isvalid_num(col)) {
                System.out.println("Invalid Column at index: " + i);

                valid = false;
                break;
            }
        }
        
       
       
        for (int i = 0; i < 9 && valid; i++) {
            int[] box = board.getSubgrid(i);

            if (!isvalid_num(box)) {
                System.out.println("Invalid subgrid at index: " + i);

                valid = false;
                break;
            }
        }
        
        if (valid) {
            System.out.println("Sudoku board is VALID.");
        } else {
            System.out.println("Sudoku board is INVALID.");
        }
    }
    
    public boolean isvalid_num(int[] arr) {

        boolean[] n = new boolean[10];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            if (num < 1 || num > 9) {
                return false;
            }
            if (n[num]) {
                return false;
            }
            n[num] = true;
        }
        return true;
    }
} 
