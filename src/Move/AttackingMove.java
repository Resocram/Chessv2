package Move;

import Builder.Board;
import Piece.Piece;

public class AttackingMove extends Move {
    private final Piece attackedPiece;
    public AttackingMove(Board board, Piece pieceToMove, int finalX, int finalY, Piece attacked) {
        super(board, pieceToMove, finalX, finalY);
        this.attackedPiece = attacked;
    }

    @Override
    public Board execute() {
        return null;
    }
}
