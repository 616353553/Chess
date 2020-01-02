import java.util.Vector;

public class Board {
    private int width;
    private int length;
    private Piece[][] pieces;
    private Vector<Piece> graveyard;

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
    }


    /**
     * Reset the board by clear graveyard and reset all pieces.
     * @return Nothing.
     * @exception Exception On bad board dimension.
     */

    public void reset() throws ArithmeticException {
        if (width < 8 || length < 8) {
            throw new ArithmeticException("Board's height/width is less than 8");
        }
        pieces = new Piece[length][width];
        graveyard = new Vector<>(32);
        for (int i = 0; i < 2; ++i) {
            int row;
            int pawnRow;
            Color playerColor;
            if (i == 0) {
                row = 0;
                pawnRow = 1;
                playerColor = Color.WHITE;
            } else {
                row = length - 1;
                pawnRow = length - 2;
                playerColor = Color.BLACK;
            }
            pieces[row][0] = new Rook(playerColor);
            pieces[row][1] = new Knight(playerColor);
            pieces[row][2] = new Bishop(playerColor);
            pieces[row][3] = new Queen(playerColor);
            pieces[row][4] = new King(playerColor);
            pieces[row][5] = new Bishop(playerColor);
            pieces[row][6] = new Knight(playerColor);
            pieces[row][7] = new Rook(playerColor);
            for (int j = 0; j < width; ++j) {
                pieces[pawnRow][j] = new Pawn(playerColor);
            }
        }
    }




    /**
     * Move the piece at (x1, y1) to location (x2, y2).
     * @param x1 The x coordinate of start location.
     * @param y1 The y coordinate of start location.
     * @param x2 The x coordinate of end location.
     * @param y2 The y coordinate of end location.
     * @return Nothing.
     * @exception Exception On input error.
     */

    public void movePiece(int x1, int  y1, int x2, int y2) throws Exception {
        if (!locationIsValid(x1, y1) || !locationIsValid(x2, y2)) {
            throw new Exception("invalid position");
        }
        Piece start = pieces[x1][y1];
        if (start == null) {
            throw new Exception("nothing to move");
        }
        Piece end = pieces[x2][y2];
        // a capture move
        if (end != null && end.getColor() != start.getColor()) {
            int[][] path = start.getMovePath(x1, y1, x2, y2);
            if (pathIsBlocked(path)) {
                throw new Exception("path is blocked");
            }
            graveyard.add(end);
        }
        // a regular move
        else {
            int[][] path = start.getCapturePath(x1, y1, x2, y2);
            if (end != null) {
                throw new Exception("tile is taken");
            }
            if (pathIsBlocked(path)) {
                throw new Exception("path is blocked");
            }
        }
        pieces[x2][y2] = start;
        pieces[x1][y1] = null;
    }




    /**
     * Check if given path is blocked by any piece(except the start and end tiles).
     * @param path The path to be checked.
     * @return True if path is blocked, false otherwise.
     */

    private boolean pathIsBlocked(int[][] path) {
        if (path == null) {
            return false;
        }
        int pathLength = path[0].length;
        if (pathLength <= 1) {
            return false;
        }
        for (int i  = 1; i < pathLength - 1; i++) {
            int x = path[0][i];
            int y = path[1][i];
            if (pieces[x][y] != null) {
                return true;
            }
        }
        return false;
    }


    /**
     * Find if any king is in check.
     * @return True if king is in check, false otherwise.
     */

    public boolean kingIsInCheck() {
        int[][] kingLoc = kingLocation();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                Piece current = pieces[i][j];
                if (current != null) {
                    if (current.getColor() == Color.WHITE) {

                    } else {

                    }
                }
            }
        }
        return false;
    }



    /**
     * Find the location of both kings.
     * @return The locations of two kings in the order white then black.
     *         The default coordinate is '-1'.
     */

    private int[][] kingLocation() {
        int[][] result = new int[2][2];
        result[0][0] = -1;
        result[0][1] = -1;
        result[1][0] = -1;
        result[1][1] = -1;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                Piece current = pieces[i][j];
                if (current != null && current instanceof King) {
                    if (current.getColor() == Color.WHITE) {
                        result[0][0] = i;
                        result[1][0] = j;
                    } else {
                        result[0][1] = i;
                        result[1][1] = j;
                    }
                }
            }
        }
        return result;
    }


    /**
     * Check if given location is on the board.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return True if is on the board, false otherwise.
     */

    public boolean locationIsValid(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= length) {
            return false;
        }
        return true;
    }



    /**
     * Get the piece on given location.
     * @param x The x coordinate of target location.
     * @param y The y coordinate of target location.
     * @return The piece at target location, null if nothing is found.
     */

    public Piece getPieceAt(int x, int y) { return pieces[x][y]; }



    /**
     * Get the width of the board.
     * @return Width of the board.
     */

    public int getWidth() {
        return this.width;
    }


    /**
     * Get the length of the board.
     * @return Length of the board.
     */

    public int getLength() {
        return this.length;
    }

}
