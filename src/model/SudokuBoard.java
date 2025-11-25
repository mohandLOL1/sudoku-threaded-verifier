package model;

public class SudokuBoard {

    int[][] board;

    private SudokuBoard(int[][] grid) {  //private constructor as to encapsulate the behaviour of the class into only reading from CSV files
        this.board = grid;
    }


    public static SudokuBoard fromCSV(String filePath) {
        int[][] loadedBoard = new int[9][9];
        // read the CSV and populate loadedBoard
        return new SudokuBoard(loadedBoard);
    }

    public int[] getRow(int i) {
        return null;
    }

    public int[] getColumn(int i) {
        return null;
    }

    public int[] getSubgrid(int i) {
        // implement subgrid retrieval logic
        return null;
    }

}






