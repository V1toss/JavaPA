package vkaretko;

import java.util.ArrayList;
import java.util.List;

/**
 * Frog class.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class Frog {
    private Position startPos;

    private Position finalPos;

    private List<Position> trees;

    private int minCount = 1000;

    public Frog(Position startPos, Position finalPos, List<Position> trees) {
        this.startPos = startPos;
        this.finalPos = finalPos;
        this.trees = trees;
    }

    public void init() {
        final int length = 16;
        final int width = 10;
        int[][] circle = new int[length][width];
        for (Position tree : trees) {
            circle[tree.getX()][tree.getY()] = -1;
        }
        recursiveJump(circle, startPos.getX(), startPos.getY(), 0, 0);
        System.out.println(circle[finalPos.getX()][finalPos.getY()]);
    }

    private void recursiveJump(int[][] circle, int x, int y, int stepX, int stepY) {

        int count = circle[x][y];
        y += stepY;
        x = (x + stepX) % 16;
        if (y < 0 && y > 9 && circle[x][y] >= 0 && count < 20) {
            return;
        }

        if (x == this.finalPos.getX() && y == this.finalPos.getY()) {
            circle[x][y] = checkMinimum(count);
        } else if (count > circle[x][y]) {
            circle[x][y] = count + 1;
            recursiveJump(circle, x, y, 3, 0);
            recursiveJump(circle, x, y, 2, 1);
            recursiveJump(circle, x, y, 1, 2);
            recursiveJump(circle, x, y, 2, -1);
            recursiveJump(circle, x, y, 1, -2);
        }
    }

    private int checkMinimum(int count) {
        return count < this.minCount ? count : minCount;
    }

    public static void main(String[] args) {
        ArrayList<Position> trees = new ArrayList<>();
        trees.add(new Position(13, 8));
        trees.add(new Position(4, 7));
        new Frog(new Position(10, 6), new Position(8, 9), trees).init();
    }
}
