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
     * Up directions.
     */
    UP {
        /**
         * Get steps for current direction.
         * @return steps.
         */
        public int[] get() {
            return new int[]{0, 1};
        }

        /**
         * Change direction to another.
         * @return new direction.
         */
        @Override
        public Direction changeDir() {
            return RIGHT;
        }
    },
    /**
     * Right direction.
     */
    RIGHT {
        /**
         * Get steps for current direction.
         * @return steps.
         */
        public int[] get() {
            return new int[]{1, 0};
        }

        /**
         * Change direction to another.
         * @return new direction.
         */
        @Override
        public Direction changeDir() {
            return DOWN;
        }
    },
    /**
     * Down direction.
     */
    DOWN {
        /**
         * Get steps for current direction.
         * @return steps.
         */
        public int[] get() {
            return new int[]{0, -1};
        }

        /**
         * Change direction to another.
         * @return new direction.
         */
        @Override
        public Direction changeDir() {
            return LEFT;
        }
    },
    /**
     * Left direction.
     */
    LEFT {
        /**
         * Get steps for current direction.
         * @return steps.
         */
        public int[] get() {
            return new int[]{-1, 0};
        }

        /**
         * Change direction to another.
         * @return new direction.
         */
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
