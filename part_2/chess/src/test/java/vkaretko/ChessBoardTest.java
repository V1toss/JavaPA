package vkaretko;

import org.junit.Before;
import org.junit.Test;
import vkaretko.figures.Bishop;
import vkaretko.figures.King;
import vkaretko.figures.Knight;
import vkaretko.figures.Queen;
import vkaretko.figures.Rook;
import vkaretko.game.ChessBoard;
import vkaretko.game.ChessFigure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class of ChessBoard and Move.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class ChessBoardTest {
    /**
     * Chess board.
     */
    private ChessBoard board = new ChessBoard();
    /**
     * Start row of position for group of tests.
     */
    private final int startRow = 3;
    /**
     * Start column of position for group of tests.
     */
    private final  int startCol = 3;

    /**
     * Initialize chess board and output stream before tests.
     */
    @Before
    public void initChessBoard() {
        board.initBoard();
    }

    /**
     * Method checks Pawn move.
     */
    @Test
    public void whenMovePawnThenResultPawnInOtherCell() {
        ChessFigure figure = board.getChessBoard()[1][startCol].getFigure();
        board.moveFigure(1, startCol, startRow - 1, startCol);
        assertThat(figure, is(board.getChessBoard()[startRow - 1][startCol].getFigure()));
    }

    /**
     * Method checks Bishop move.
     */
    @Test
    public void whenMoveBishopThenResultBishopInOtherCell() {
        ChessFigure bishop = new Bishop(true);
        board.getChessBoard()[startRow][startCol].setFigure(bishop);
        board.moveFigure(startRow, startCol, startRow + 1, startCol + 1);
        assertThat(bishop, is(board.getChessBoard()[startRow + 1][startCol + 1].getFigure()));
    }

    /**
     * Method checks Bishop move Left Top diagonal.
     */
    @Test
    public void whenMoveBishopLeftTopThenResultBishopInOtherCell() {
        ChessFigure bishop = new Bishop(true);
        board.getChessBoard()[startRow][startCol].setFigure(bishop);
        board.moveFigure(startRow, startCol, startRow + 1, startCol - 1);
        assertThat(bishop, is(board.getChessBoard()[startRow + 1][startCol - 1].getFigure()));
    }

    /**
     * Method checks Bishop move Right Down diagonal.
     */
    @Test
    public void whenMoveBishopRightDownThenResultBishopInOtherCell() {
        ChessFigure bishop = new Bishop(true);
        board.getChessBoard()[startRow][startCol].setFigure(bishop);
        board.moveFigure(startRow, startCol, startRow - 1, startCol + 1);
        assertThat(bishop, is(board.getChessBoard()[startRow - 1][startCol + 1].getFigure()));
    }

    /**
     * Method checks King move.
     */
    @Test
    public void whenMoveKingThenResultKingInOtherCell() {
        ChessFigure king = new King(true);
        board.getChessBoard()[startRow][startCol].setFigure(king);
        board.moveFigure(startRow, startCol, startRow, startCol + 1);
        assertThat(king, is(board.getChessBoard()[startRow][startCol + 1].getFigure()));
    }

    /**
     * Method checks Knight move.
     */
    @Test
    public void whenMoveKnightThenResultKnightInOtherCell() {
        ChessFigure knight = new Knight(true);
        board.getChessBoard()[startRow][startCol].setFigure(knight);
        board.moveFigure(startRow, startCol, startRow + 2, startCol + 1);
        assertThat(knight, is(board.getChessBoard()[startRow + 2][startCol + 1].getFigure()));
    }

    /**
     * Method checks Queen move.
     */
    @Test
    public void whenMoveQueenThenResultQueenInOtherCell() {
        ChessFigure queen = new Queen(true);
        board.getChessBoard()[startRow][startCol].setFigure(queen);
        board.moveFigure(startRow, startCol, startRow - 1, startCol - 1);
        assertThat(queen, is(board.getChessBoard()[startRow - 1][startCol - 1].getFigure()));
    }

    /**
     * Method checks Rook move.
     */
    @Test
    public void whenMoveRookThenResultRookInOtherCell() {
        ChessFigure rook = new Rook(true);
        board.getChessBoard()[startRow][startCol].setFigure(rook);
        board.moveFigure(startRow, startCol, startRow, startCol + 2);
        assertThat(rook, is(board.getChessBoard()[startRow][startCol + 2].getFigure()));
    }

    /**
     * Method checks Rook backward move.
     */
    @Test
    public void whenMoveRookBackwardThenResultRookInOtherCell() {
        ChessFigure rook = new Rook(true);
        board.getChessBoard()[startRow + 1][startCol].setFigure(rook);
        board.moveFigure(startRow + 1, startCol, startRow - 1, startCol);
        assertThat(rook, is(board.getChessBoard()[startRow - 1][startCol].getFigure()));
    }

}
