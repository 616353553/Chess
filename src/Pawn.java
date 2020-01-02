public class Pawn extends Piece {

    private boolean moved = false;

    public Pawn(Color color) {
        this.color = color;
    }


    protected boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Moving horizontally
        if (x1 != x2) {
            return false;
        }
        // same location
        if (y1 == y2) {
            return false;
        }
        // Moving forward
        else if ((y1 < y2 && this.color == Color.WHITE) || (y1 > y2 && this.color == Color.WHITE)) {
            int distance = Math.abs(y1 - y2);
            // move more than 2 tiles
            if (distance > 2) {
                return false;
            }
            // move exactly 2 tiles
            else if (distance == 2) {
                // never moved before
                if (this.moved == false) {
                    this.moved = true;
                    return true;
                }
                return false;
            }
            this.moved = true;
            return true;
        }
        return false;
    }


    protected boolean isValidCapture(int x1, int y1, int x2, int y2) {
        // trying to move forward
        if ((y1 < y2 && this.color == Color.WHITE) || (y1 > y2 && this.color == Color.WHITE)) {
            // trying to capture vertically
            if (x1 == x2) {
                return false;
            }
            // trying to capture diagonally with distance sqrt(2)
            if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1) {
                return true;
            }
        }
        return false;
    }

    public int[][] getMovePath(int x1, int y1, int x2, int y2) {
        if (isValidMove(x1, y1, x2, y2)) {
            return combineSeries(generateSeriesFromRange(x1, x2), generateSeriesFromRange(y1, y2));
        }
        return null;
    }

    public int[][] getCapturePath(int x1, int y1, int x2, int y2) {
        if (isValidCapture(x1, y1, x2, y2)) {
            return combineSeries(generateSeriesFromRange(x1, x2), generateSeriesFromRange(y1, y2));
        }
        return null;
    }
}
