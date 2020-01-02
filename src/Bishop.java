public class Bishop extends Piece {

    public Bishop(Color color) {
        this.color = color;
    }

    protected boolean isValidMove(int x1, int y1, int x2, int y2) {
        // same location
        if ((x1 == x2) && (y1 == y2)) {
            return false;
        }
        // moving diagonally
        if (Math.abs(x1 - x2) == Math.abs(y1 -y2)) {
            return true;
        }
        return false;
    }

    protected boolean isValidCapture(int x1, int y1, int x2, int y2) {
        return isValidMove(x1, y1, x2, y2);
    }

    public int[][] getMovePath(int x1, int y1, int x2, int y2) {
        if (isValidMove(x1, y1, x2, y2)) {
            return combineSeries(generateSeriesFromRange(x1, x2), generateSeriesFromRange(y1, y2));
        }
        return null;
    }

    public int[][] getCapturePath(int x1, int y1, int x2, int y2) {
        return getMovePath(x1, y1, x2, y2);
    }
}
