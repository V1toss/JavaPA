package vkaretko.game;

import vkaretko.figures.Bishop;
import vkaretko.figures.King;
import vkaretko.figures.Knight;
import vkaretko.figures.Pawn;
import vkaretko.figures.Queen;
import vkaretko.figures.Rook;

/**
 * Class of figure moves.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */

public class Move {

    /**
     * Array of board cells.
     */
    private Cell[][] board;
    /**
     * Source Cell row.
     */
    private int srcRow;
    /**
     * Source Cell column.
     */
    private int srcCol;
    /**
     * Destination Cell row.
     */
    private int dstRow;
    /**
     * Destination Cell column.
     */
    private int dstCol;
    /**
     * Source Cell.
     */
    private Cell srcCell;

    /**
     * Constructor of Move class.
     * @param board Chess board
     * @param srcRow source Cell row
     * @param srcCol source Cell column
     * @param dstRow destination cell wow
     * @param dstCol destination cell column
     */
    Move(Cell[][] board, int srcRow, int srcCol, int dstRow, int dstCol) {
        this.board = board;
        this.srcRow = srcRow;
        this.srcCol = srcCol;
        this.dstRow = dstRow;
        this.dstCol = dstCol;
        this.srcCell = board[srcRow][srcCol];
    }

    /**
     * Method checks instance of figure classes and execute move methods.
     * @throws ChessBoardException if there problem
     */
    public void makeMove() throws ChessBoardException {
        if (srcCell.getFigure() instanceof Pawn) {
            movePawn();
        } else if (srcCell.getFigure() instanceof Bishop) {
            moveBishop();
        } else if (srcCell.getFigure() instanceof King) {
            moveKing();
        } else if (srcCell.getFigure() instanceof Queen) {
            moveQueen();
        } else if (srcCell.getFigure() instanceof Rook) {
            moveRook();
        } else if (srcCell.getFigure() instanceof Knight) {
            moveKnight();
        }
    }

    /**
     * Method move Pawn figure.
     * @throws ChessBoardException if there problem
     */
    private void movePawn() throws ChessBoardException {
        int pawnStep = 1;
        int maxFirstStep = 2;
        if ((srcCell.getFigure().isWhite() && (dstRow < srcRow)
                || (srcCol != dstCol)) || (!srcCell.getFigure().isWhite() && dstRow > srcRow)) {
            throw new ChessBoardException("Wrong direction of move");
        }

        if (Math.abs(dstRow - srcRow) == pawnStep) {
            ((Pawn) (srcCell.getFigure())).setFirstMove(false);
            setFigureInDestCell();
        } else if (Math.abs(dstRow - srcRow) == maxFirstStep) {
            if (!((Pawn) srcCell.getFigure()).isFirstMove()) {
                throw new ChessBoardException("Pawn can move 2 steps only when first move");
            } else if (board[(srcRow + dstRow) / 2][(srcCol + dstCol) / 2].isEmpty()) {
                ((Pawn) (srcCell.getFigure())).setFirstMove(false);
                setFigureInDestCell();
            }
        }
    }

    /**
     * Method move Rook figure.
     * @throws ChessBoardException if there problem
     */
    private void moveRook() throws ChessBoardException {
        if (isVerticalDirection()) {
            moveStepVertical();
        } else if (isHorizontalDirection()) {
            moveStepHorizontal();
        } else {
            throw new ChessBoardException(String.format("Wrong move of %s", srcCell.getFigure().getName()));
        }
    }

    /**
     * Method move King figure.
     * @throws ChessBoardException if there problem
     */
    private void moveKing() throws ChessBoardException {
        int maxStep = ((King) srcCell.getFigure()).getMaxStep();

        if (isVerticalDirection() && Math.abs(srcRow - dstRow) == maxStep) {
            setFigureInDestCell();
        } else if (isDiagonalDirection() && Math.abs(srcRow - dstRow) == maxStep) {
            setFigureInDestCell();
        } else if (isHorizontalDirection() && Math.abs(srcCol - dstCol) == maxStep) {
            setFigureInDestCell();
        } else {
            throw new ChessBoardException(String.format("Wrong move of %s", srcCell.getFigure().getName()));
        }
    }

    /**
     * Method move Queen figure.
     * @throws ChessBoardException if there problem
     */
    private void moveQueen() throws ChessBoardException {
        if (isVerticalDirection()) {
            moveStepVertical();
        } else if (isDiagonalDirection()) {
            moveStepDiag();
        } else if (isHorizontalDirection()) {
            moveStepHorizontal();
        } else {
            throw new ChessBoardException(String.format("Wrong move of %s", srcCell.getFigure().getName()));
        }
    }

    /**
     * Method move Knight figure.
     * @throws ChessBoardException if there problem
     */
    private void moveKnight() throws ChessBoardException {
        int knightSteps = ((Knight) srcCell.getFigure()).getSteps();
        if (!isVerticalDirection() && !isHorizontalDirection() && !isDiagonalDirection()
                && (Math.abs(srcRow - dstRow) + Math.abs(srcCol - dstCol) == knightSteps)) {
                setFigureInDestCell();
        } else {
            throw new ChessBoardException(String.format("Wrong move of %s", srcCell.getFigure().getName()));
        }
    }

    /**
     * Method move Bishop figure.
     * @throws ChessBoardException if there problem
     */
    private void moveBishop() throws ChessBoardException {
        if (isDiagonalDirection()) {
            moveStepDiag();
        } else {
            throw new ChessBoardException(String.format("Wrong move of %s", srcCell.getFigure().getName()));
        }
    }

    /**
     * Method checks that destination cell is on diagonal of source Cell.
     * @return result of check
     */
    private boolean isDiagonalDirection() {
        return Math.abs(dstRow - srcRow) == Math.abs(dstCol - srcCol);
    }

    /**
     * Method checks that destination cell is on vertical line of source Cell.
     * @return result of check
     */
    private boolean isVerticalDirection() {
        return srcCol == dstCol;
    }

    /**
     * Method checks that destination cell is on horizontal line of source Cell.
     * @return result of check
     */
    private boolean isHorizontalDirection() {
        return srcRow == dstRow;
    }

    /**
     * Method for diagonal move.
     * @throws ChessBoardException if there problem
     */
    public void moveStepDiag() throws ChessBoardException {
        if (dstRow > srcRow && dstCol > srcCol) {
            int stepCol = srcCol + 1;
            for (int stepRow = srcRow + 1; stepRow <= dstRow;) {
                if (!this.board[stepRow++][stepCol++].isEmpty()) {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }

        if (dstRow > srcRow && dstCol < srcCol) {
            int stepCol = srcCol - 1;
            for (int stepRow = srcRow + 1; stepRow <= dstRow;) {
                if (!this.board[stepRow++][stepCol--].isEmpty()) {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }

        if (dstRow < srcRow && dstCol < dstRow) {
            int stepCol = srcCol - 1;
            for (int stepRow = srcRow - 1; stepRow >= dstRow;) {
                if (!this.board[stepRow--][stepCol--].isEmpty()) {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }

        if (dstRow < srcRow && dstCol > dstRow) {
            int stepCol = srcCol + 1;
            for (int stepRow = srcRow - 1; stepRow >= dstRow;) {
                if (!this.board[stepRow--][stepCol++].isEmpty()) {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }
        setFigureInDestCell();
    }

    /**
     * Method for vertical move.
     * @throws ChessBoardException if there problem
     */
    private void moveStepVertical() throws ChessBoardException {
        if (dstRow > srcRow) {
            for (int step = srcRow + 1; step <= dstRow;) {
                if (this.board[step][srcCol].isEmpty()) {
                    step++;
                } else {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }

        if (dstRow < srcRow) {
            for (int step = srcRow - 1; step >= dstRow;) {
                if (this.board[step][srcCol].isEmpty()) {
                    step--;
                } else {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }
        setFigureInDestCell();
    }

    /**
     * Method for horizontal move.
     * @throws ChessBoardException if there problem
     */
    private void moveStepHorizontal() throws ChessBoardException {
        if (dstCol > srcCol) {
            for (int step = srcCol + 1; step <= dstCol;) {
                if (this.board[srcRow][step].isEmpty()) {
                    step++;
                } else {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }

        if (dstCol < srcCol) {
            for (int step = srcCol - 1; step >= dstCol;) {
                if (this.board[srcRow][step].isEmpty()) {
                    step--;
                } else {
                    throw new ChessBoardException("Another figure on movement line");
                }
            }
        }
        setFigureInDestCell();
    }

    /**
     * Method for reallocate figure in destination cell.
     */
    private void setFigureInDestCell() {
        board[dstRow][dstCol].setFigure(srcCell.getFigure());
        board[srcRow][srcCol].setFigure(null);
    }
}
