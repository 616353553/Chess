public class Knight extends Piece {

    public Knight(Color color) {
        this.color = color;
    }

    protected boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Moving vertically in 'L' shape
        if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2) {
            return true;
        }
        // Moving horizontally in 'L' shape
        else if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) {
            return true;
        }
        return false;
    }

    protected boolean isValidCapture(int x1, int y1, int x2, int y2) {
        return isValidMove(x1, y1, x2, y2);
    }

    public int[][] getMovePath(int x1, int y1, int x2, int y2) {
        if (isValidMove(x1, y1, x2, y2)) {
            int[][] result = new int[2][2];
            result[0][0] = x1;
            result[0][1] = x2;
            result[1][0] = y1;
            result[1][1] = y2;
            return result;
        }
        return null;
    }


    public int[][] getCapturePath(int x1, int y1, int x2, int y2) {
        return getMovePath(x1, y1, x2, y2);
    }

}
