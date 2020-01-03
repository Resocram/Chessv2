package ChessPlayer;

import Builder.Board;
import Move.Move;
import Piece.Piece;
import Piece.Player;


import java.util.List;

public class blackPlayer extends ChessPlayer {

    public blackPlayer(Board board, List<Move> whiteLegalMoves, List<Move> blackLegalMoves) {
        super(board, blackLegalMoves, whiteLegalMoves);
    }

    @Override
    public List<Piece> getPieces(){
        return this.board.getBlackPieces();
    }

    @Override
    public Player getPlayer() {
        return Player.BLACK;
    }

    @Override
    public ChessPlayer getOpponent() {
        return this.board.whitePlayer();
    }


}
