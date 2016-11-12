package vkaretko;

import org.junit.Before;
import org.junit.Test;
import vkaretko.figures.Bishop;
import vkaretko.figures.King;
import vkaretko.figures.Queen;
import vkaretko.figures.Rook;
import vkaretko.figures.Knight;
import vkaretko.figures.Pawn;
import vkaretko.game.ChessBoard;
import vkaretko.game.ChessFigure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class of test exceptions.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class ChessBoardExceptionsTest {
    /**
     * Chess board.
     */
    private ChessBoard board = new ChessBoard();
    /**
     * Output stream for work with System.out.
     */
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

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
    public void initChessBoardAndOutputStream() {
        board.initBoard();
        System.setOut(new PrintStream(out));
    }

    /**
     * Method checks that pawn cant go twice through 2 cells.
     */
    @Test
    public void whenMovePawnTwoTimesThroughTwoCellsThenResultPawnException() {
        board.moveFigure(1, startCol, startRow - 1, startCol);
        board.moveFigure(2, startCol, startRow + 1, startCol);
        assertThat(out.toString(),
                is("Pawn can move 2 steps only when first move\r\n"));
    }

    /**
     * Method checks exception another figure on line.
     */
    @Test
    public void whenMoveRookAndOnLineOtherFigureThenResultMovementException() {
        ChessFigure rook = new Rook(true);
        ChessFigure pawn = new Pawn(true);
        board.getChessBoard()[startRow - 1][startCol].setFigure(rook);
        board.getChessBoard()[startRow][startCol].setFigure(pawn);
        board.moveFigure(startRow - 1, startCol, startRow + 1, startCol);
        assertThat(out.toString(), is("Another figure on movement line\r\n"));
    }

    /**
     * Method checks exception Same cell.
     */
    @Test
    public void whenMoveToSameCellThenResultSameCellException() {
        ChessFigure bishop = new Bishop(true);
        board.getChessBoard()[startRow][startCol].setFigure(bishop);
        board.moveFigure(startRow, startCol, startRow, startCol);
        assertThat(out.toString(), is("Same cell\r\n"));
    }

    /**
     * Method checks exception Cell is out of board.
     */
    @Test
    public void whenMoveFiguresAreOutOfBoardThenResultOutOfBoardException() {
        board.moveFigure(-startRow, 0, 0, 0);
        assertThat(out.toString(), is("Cell is out of board\r\n"));
    }

    /**
     * Method checks exception when try to move figure from empty cell.
     */
    @Test
    public void whenTryToMoveFigureFromEmptyCellThenResultEmptyCellException() {
        board.moveFigure(startRow, startCol, startRow, startCol + 1);
        assertThat(out.toString(), is("Empty cell\r\n"));
    }

    /**
     * Method checks exception when destination cell is not empty.
     */
    @Test
    public void whenTryToMovePawnToNotEmptyCellThenResultNotEmptyException() {
        ChessFigure pawnFirst = new Pawn(true);
        ChessFigure pawnSecond = new Pawn(true);
        board.getChessBoard()[startRow][startCol].setFigure(pawnFirst);
        board.getChessBoard()[startRow + 1][startCol].setFigure(pawnSecond);
        board.moveFigure(startRow, startCol, startRow + 1, startCol);
        assertThat(out.toString(), is("Destination cell is not empty\r\n"));
    }

    /**
     * Method checks exception when Pawn go wrong way.
     */
    @Test
    public void whenMovePawnWrongWayThenResultPawnWrongDirectionException() {
        ChessFigure pawn = new Pawn(true);
        board.getChessBoard()[startRow][startCol].setFigure(pawn);
        board.moveFigure(startRow, startCol, startRow, startCol + 1);
        assertThat(out.toString(), is("Wrong direction of move\r\n"));
    }

    /**
     * Method checks exception when Knight move not like Knight.
     */
    @Test
    public void whenMoveKnightToWrongCellThenResultWrongMoveException() {
        ChessFigure knight = new Knight(true);
        board.getChessBoard()[startRow][startCol].setFigure(knight);
        board.moveFigure(startRow, startCol, startRow + 1, startCol + 1);
        assertThat(out.toString(), is("Wrong move of Knight\r\n"));
    }

    /**
     * Method checks exception when Bishop have wrong direction of move.
     */
    @Test
    public void whenMoveBishopToWrongCellThenResultWrongMoveException() {
        ChessFigure bishop = new Bishop(true);
        board.getChessBoard()[startRow][startCol].setFigure(bishop);
        board.moveFigure(startRow, startCol, startRow, startCol + 1);
        assertThat(out.toString(), is("Wrong move of Bishop\r\n"));
    }

    /**
     * Method checks exception when King move is wrong.
     */
    @Test
    public void whenMoveKingTwoStepsThenResultWrongMoveException() {
        ChessFigure king = new King(true);
        board.getChessBoard()[startRow][startCol].setFigure(king);
        board.moveFigure(startRow, startCol, startRow, startCol + 2);
        assertThat(out.toString(), is("Wrong move of King\r\n"));
    }

    /**
     * Method checks exception when Queen move wrong (like Knight).
     */
    @Test
    public void whenMoveQueenLikeKnightThenResultWrongMoveException() {
        ChessFigure queen = new Queen(true);
        board.getChessBoard()[startRow][startRow].setFigure(queen);
        board.moveFigure(startRow, startCol, startRow + 1, startCol + 2);
        assertThat(out.toString(), is("Wrong move of Queen\r\n"));
    }

    /**
     * Method checks exception when Rook move wrong.
     */
    @Test
    public void whenMoveRookInWrongWayThenResultWrongMoveException() {
        ChessFigure rook = new Rook(true);
        board.getChessBoard()[startRow][startCol].setFigure(rook);
        board.moveFigure(startRow, startCol, startRow + 1, startCol + 1);
        assertThat(out.toString(), is("Wrong move of Rook\r\n"));
    }
}
