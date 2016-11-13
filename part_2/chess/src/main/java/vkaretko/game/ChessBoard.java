package vkaretko.game;

import vkaretko.figures.Bishop;
import vkaretko.figures.King;
import vkaretko.figures.Knight;
import vkaretko.figures.Pawn;
import vkaretko.figures.Queen;
import vkaretko.figures.Rook;

/**
 * Class of Chess Board.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class ChessBoard {
    /**
     * Size of chess board.
     */
    private final int sizeOfBoard = 8;
    /**
     * Array of cells to init board.
     */
    private Cell[][] board = new Cell[sizeOfBoard][sizeOfBoard];
    /**
     * Color to set up figures.
     */
    private boolean white = true;
    /**
     * Array of cells to init board.
     */
    private enum Figures { ROOK, KNIGHT, BISHOP, QUEEN, KING }

    /**
     * Method to fill chess board with cells.
     */
    public void initBoard() {
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board.length; column++) {
                this.board[row][column] = new Cell();
            }
        }

        fillFiguresOnBoard(white);
        fillFiguresOnBoard(white);
    }

    /**
     * Method to fill figures in cells on chess board.
     * @param white color of figures
     */
    private void fillFiguresOnBoard(boolean white) {
        int firstLineForBlack = sizeOfBoard - 1;
        int firstLineForWhite = 0;
        int secondLineForWhite = 1;
        int secondLineForBlack = firstLineForBlack - 1;
        int fstLine = white ? firstLineForWhite : firstLineForBlack;
        int sndLine = white ? secondLineForWhite : secondLineForBlack;

        for (int column = 0; column < board.length; column++) {
            board[sndLine][column].setFigure(new Pawn(white));
        }

        board[fstLine][Figures.ROOK.ordinal()].setFigure(new Rook(white));
        board[fstLine][Figures.KNIGHT.ordinal()].setFigure(new Knight(white));
        board[fstLine][Figures.BISHOP.ordinal()].setFigure(new Bishop(white));
        board[fstLine][Figures.QUEEN.ordinal()].setFigure(new Queen(white));
        board[fstLine][Figures.KING.ordinal()].setFigure(new King(white));
        board[fstLine][board.length - 1 - Figures.ROOK.ordinal()].setFigure(new Rook(white));
        board[fstLine][board.length - 1 - Figures.KNIGHT.ordinal()].setFigure(new Knight(white));
        board[fstLine][board.length - 1 - Figures.BISHOP.ordinal()].setFigure(new Rook(white));
    }

    /**
     * Method to initiate moving figures.
     * Also catches all exceptions and print their message.
     * @param srcRow source row
     * @param srcCol source column
     * @param dstRow destination row
     * @param dstCol destination column
     */
    public void moveFigure(int srcRow, int srcCol, int dstRow, int dstCol) {
        try {
            checkCell(srcCol, srcRow, dstCol, dstRow);
            Move move = new Move(board, srcRow, srcCol, dstRow, dstCol);
            move.makeMove();
        } catch (ChessBoardException cbe) {
            System.out.println(cbe.getMessage());
        }
    }

    /**
     * Method to check valid of arguments and return exceptions.
     * @param srcRow source row
     * @param srcCol source column
     * @param dstRow destination row
     * @param dstCol destination column
     * @throws ChessBoardException if cell coordinates are wrong
     */
    private void checkCell(int srcCol, int srcRow, int dstCol, int dstRow) throws ChessBoardException {
        if ((srcRow == dstRow) && (srcCol == dstCol)) {
            throw new ChessBoardException("Same cell");
        }

        if (srcRow >= board.length || srcRow < 0 || srcCol >= board.length || srcCol < 0
                || dstRow >= board.length || dstRow < 0 || dstCol >= board.length || dstCol < 0) {
            throw new ChessBoardException("Cell is out of board");
        }

        if (this.board[srcRow][srcCol].isEmpty()) {
            throw new ChessBoardException("Empty cell");
        }

        if (!this.board[dstRow][dstCol].isEmpty()) {
            throw new ChessBoardException("Destination cell is not empty");
        }
    }

    /**
     * Getter method for chess board array.
     * @return chess board
     */
    public Cell[][] getChessBoard() {
        return board;
    }
}
