package vkaretko.models;

/**
 * Enum direction.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public enum Direction {
    /**
     * Four directions.
     */
    UP {
        public int[] get() {
            return new int[]{0, 1};
        }

        @Override
        public Direction changeDir() {
            return RIGHT;
        }
    },
    RIGHT {
        public int[] get() {
            return new int[]{1, 0};
        }

        @Override
        public Direction changeDir() {
            return DOWN;
        }
    },
    DOWN {
        public int[] get() {
            return new int[]{0, -1};
        }

        @Override
        public Direction changeDir() {
            return LEFT;
        }
    },
    LEFT {
        public int[] get() {
            return new int[]{-1, 0};
        }

        @Override
        public Direction changeDir() {
            return UP;
        }
    };

    /**
     * Method returns steps x and y of direction.
     * @return array with x and y steps.
     */
    public abstract int[] get();

    /**
     * Method selects next direction.
     * @return next direction.
     */
    public abstract Direction changeDir();
}
