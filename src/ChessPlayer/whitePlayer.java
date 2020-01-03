package ChessPlayer;

import Builder.Board;
import Move.Move;
import Piece.Piece;
import Piece.Player;

import java.util.List;

public class whitePlayer extends ChessPlayer {


    public whitePlayer(Board board, List<Move> whiteLegalMoves, List<Move> blackLegalMoves) {
        super(board, whiteLegalMoves, blackLegalMoves);
    }

    @Override
    public List<Piece> getPieces(){
        return this.board.getWhitePieces();
    }

    @Override
    public Player getPlayer() {
        return Player.WHITE;
    }

    @Override
    public ChessPlayer getOpponent() {
        return this.board.blackPlayer();
    }


}
