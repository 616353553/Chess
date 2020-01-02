public abstract class Piece {

    protected Color color;

    /**
     * Check if the target location is reachable using the move rule.
     * @param x1 The x coordinate of start location.
     * @param y1 The y coordinate of start location.
     * @param x2 The x coordinate of end location.
     * @param y2 The y coordinate of end location.
     * @return True if the piece can move to target location, false otherwise.
     */

    protected abstract boolean isValidMove(int x1, int y1, int x2, int y2);

    /**
     * Check if the target location is reachable using the capture rule.
     * @param x1 The x coordinate of start location.
     * @param y1 The y coordinate of start location.
     * @param x2 The x coordinate of end location.
     * @param y2 The y coordinate of end location.
     * @return True if the piece can move to target location, false otherwise.
     */

    protected abstract boolean isValidCapture(int x1, int y1, int x2, int y2);

    /**
     * Get the path from start location to end location using the move rule.
     * @param x1 The x coordinate of start location.
     * @param y1 The y coordinate of start location.
     * @param x2 The x coordinate of end location.
     * @param y2 The y coordinate of end location.
     * @return The path from start to end, null if not reachable.
     */
    public abstract int[][] getMovePath(int x1, int y1, int x2, int y2);

    /**
     * Get the path from start location to end location using the capture rule.
     * @param x1 The x coordinate of start location.
     * @param y1 The y coordinate of start location.
     * @param x2 The x coordinate of end location.
     * @param y2 The y coordinate of end location.
     * @return The path from start to end, null if not reachable.
     */
    public abstract int[][] getCapturePath(int x1, int y1, int x2, int y2);



    /**
     * Get the color of piece.
     * @return The color of piece.
     */
    public Color getColor() {
        return color;
    }


    /**
     * Combine two arrays into a 2-D array.
     * @param arr1 The first array.
     * @param arr2 The second array.
     * @return The 2-D array which contains arr1 and arr2.
     */

    protected int[][] combineSeries(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return null;
        }
        int[][] result = new int[2][arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            result[0][i] = arr1[i];
            result[1][i] = arr2[i];
        }
        return result;
    }

    /**
     * Generate a series of numbers start from a to b(inclusive).
     * @param a The start value.
     * @param b The end value.
     * @return The series of numbers stored in an array.
     */

    protected int[] generateSeriesFromRange(int a, int b) {
        if (a < b) {
            int[] series = new int[b - a + 1];
            for (int i = 0; i <= b - a; ++i) {
                series[i] = a + i;
            }
            return series;
        } else if (a > b) {
            int[] series = new int[a - b + 1];
            for (int i = 0; i <= a - b; ++i) {
                series[i] = a - i;
            }
            return series;
        } else {
            return null;
        }
    }

}
