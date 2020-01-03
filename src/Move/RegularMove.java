package Move;

import Builder.Board;
import Builder.Builder;
import Piece.Piece;

public class RegularMove extends Move {
    public RegularMove(Board board, Piece pieceToMove, int finalX, int finalY) {
        super(board, pieceToMove, finalX, finalY);
    }

    @Override
    public Board execute() {
        Builder builder = new Builder();
        for(Piece piece: getBoard().currentPlayer().getPieces()){
            if(!getPieceToMove().equals(piece)){
                builder.setPiece(piece);
            }

        }
        for(Piece piece: getBoard().currentPlayer().getOpponent().getPieces()){
            builder.setPiece(piece);
        }
        builder.setMoveMaker(null);
        builder.setMoveMaker(getBoard().currentPlayer().getOpponent().getPlayer());
        return builder.build();
    }
}
