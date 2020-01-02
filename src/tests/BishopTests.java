import junit.framework.TestCase;
import junit.framework.Assert;

import java.util.Arrays;

public class BishopTests extends TestCase {

    public void testConstructor() {
        Bishop bishop = new Bishop(Color.WHITE);
        assertEquals("different color", Color.WHITE, bishop.getColor());
    }


    public void testValidPaths() {
        Bishop bishop = new Bishop(Color.WHITE);
        // diagonal path 1
        int[][] path = bishop.getMovePath(4, 2, 6, 4);
        int[][] expectedPath = {{4, 5, 6}, {2, 3, 4}};
        assertTrue(Arrays.deepEquals(expectedPath, path));
        // diagonal path 2
        path = bishop.getMovePath(6, 8, 3, 5);
        int[][] expectedPath2 = {{6, 5, 4, 3}, {8, 7, 6, 5}};
        assertTrue(Arrays.deepEquals(expectedPath2, path));
    }

    public void testInvalidPath() {
        Bishop bishop = new Bishop(Color.WHITE);
        int[][] path = bishop.getMovePath(3, 1, 6, 5);
        assertTrue(Arrays.deepEquals(null, path));
    }

    public void testValidMoves() {
//        Bishop bishop = new Bishop(3, 7, )
    }

    public void testIsValidMove() {
    }

    public void testIsValidCapture() {
    }
}