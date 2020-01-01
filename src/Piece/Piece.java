package Piece;

import Board.Board;
import Move.Move;

import java.util.List;

public abstract class Piece {
    protected final int xPiece;
    protected final int yPiece;
    protected final Player player;

    public Piece(int xPiece, int yPiece, Player player) {
        this.player = player;
        this.xPiece = xPiece;
        this.yPiece = yPiece;
    }

    public abstract List<Move> possibleMoves(Board board);
    public Player getPlayer(){
        return this.player;
    }
    public abstract boolean checkValidMove(int newX, int newY);


}
