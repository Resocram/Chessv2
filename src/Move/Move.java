package Move;

import Builder.Board;
import Piece.Piece;

public abstract class Move {
    private Board board;
    private Piece pieceToMove;
    private int finalX;
    private int finalY;

    public Move(Board board, Piece pieceToMove, int finalX, int finalY) {
        this.board = board;
        this.pieceToMove = pieceToMove;
        this.finalX = finalX;
        this.finalY = finalY;
    }

}
