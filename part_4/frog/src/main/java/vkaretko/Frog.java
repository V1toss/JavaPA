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

    private final int width = 10;

    private final int length = 16;

    public Frog(Position startPos, Position finalPos, List<Position> trees) {
        this.startPos = startPos;
        this.finalPos = finalPos;
        this.trees = trees;
    }

    public void init() {
        recursiveJump(startPos.getX(), startPos.getY(), 0, 0, -1);
        System.out.println(minCount);

    }

    private void recursiveJump(int x, int y, int stepX, int stepY, int count) {
        count++;
        y += stepY;
        x = (x + stepX) % this.length;

        if (this.finalPos.getX() == x && this.finalPos.getY() == y) {
            checkMinimum(count);
        }

        if (y >= 0 && y < width && !isTree(x, y) && count < 12) {
            recursiveJump(x, y, 3, 0, count);
            recursiveJump(x, y, 2, 1, count);
            recursiveJump(x, y, 1, 2, count);
            recursiveJump(x, y, 2, -1, count);
            recursiveJump(x, y, 1, -2, count);
        }
    }

    private boolean isTree(int x, int y) {
        boolean result = false;
        for (Position tree : trees) {
            if (tree.getX() == x && tree.getY() == y) {
                result = true;
                break;
            }
        }
        return result;
    }

    private void checkMinimum(int count) {
        if (count < this.minCount) {
            this.minCount = count;
        }
    }

    public static void main(String[] args) {
        ArrayList<Position> trees = new ArrayList<>();
        trees.add(new Position(13, 8));
        trees.add(new Position(4, 7));
        new Frog(new Position(10, 6), new Position(8, 9), trees).init();
    }
}
