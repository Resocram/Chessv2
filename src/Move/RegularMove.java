package Move;

import Board.Board;
import Piece.Piece;

public class RegularMove extends Move {
    public RegularMove(Board board, Piece pieceToMove, int finalX, int finalY) {
        super(board, pieceToMove, finalX, finalY);
    }
}
