package model;

import io.CSVFileHandler;

import java.io.IOException;

public class SudokuBoard {

    int[][] board;

    private SudokuBoard(int[][] grid) {  //private constructor as to encapsulate the behaviour of the class into only reading from CSV files
        this.board = grid;
    }


    public static SudokuBoard fromCSV(String filePath) throws IOException {
        int[][] loadedBoard = CSVFileHandler.getInstance().CSVReader(filePath);
        return new SudokuBoard(loadedBoard);
    }

    public int[] getRow(int i) {
        int[] row = new int[9];
        for (int j = 0; j < 9; j++) {
            row[j] = board[i][j];
        }
        return row;
    }

    public int[] getColumn(int i) {
        int[] col = new int[9];
        for (int j = 0; j < 9; j++) {
            col[j] = board[j][i];
        }
        return col;
    }

    public int[] getSubgrid(int i) {
        int[] sub = new int[9];

        int rowStart = (i / 3) * 3;
        int colStart = (i % 3) * 3;

        int index = 0;
        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                sub[index++] = board[r][c];
            }
        }
        return sub;
    }
}






