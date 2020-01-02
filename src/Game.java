public class Game {
    public static void main(String[] args) {
        Board chessBoard = new Board(8, 8);
        Player playerA = new Player(Color.WHITE);
        Player playerB = new Player(Color.BLACK);

        Color turn = Color.BLACK;
        while (true) {

            // move piece

//            try {
//                chessBoard.movePiece(, , , );
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                continue;;
//            }
//
//
//            if (chessboard.checkmate) {
//                 break;
//            }

            if (turn == Color.BLACK) {
                turn = Color.WHITE;
            } else {
                turn = Color.BLACK;
            }
        }
    }


}
