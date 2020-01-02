public class King extends Piece {

    public King(Color color) {
        this.color = color;
    }

    protected boolean isValidMove(int x1, int y1, int x2, int y2) {
        int horizontal_distance = Math.abs(x1 - x2);
        int vertical_distance = Math.abs(y1 - y2);
        // trying to move diagonally
        if (horizontal_distance == 1 && vertical_distance == 1) {
            return true;
        }
        // trying to move horizontally
        else if (horizontal_distance == 1 && vertical_distance == 0) {
            return true;
        }
        // trying to move vertically
        else if (horizontal_distance == 0 && vertical_distance == 1) {
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
