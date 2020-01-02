public class Rook extends Piece {

    public Rook(Color color) {
        this.color = color;
    }

    protected boolean isValidMove(int x1, int y1, int x2, int y2) {
        // trying to move vertically
        if (x1 == x2 && y1 != y2) {
            return true;
        }
        // trying to move horizontally
        else if (x1 != x2 && y1 == y2) {
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
        return combineSeries(generateSeriesFromRange(x1, x2), generateSeriesFromRange(y1, y2));
    }
}
