package Piece;

import Board.Board;
import Move.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class King extends Piece {
    private final static int[][] POSSIBLE_MOVES = {{-1, -1}, {-1, 0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public King(int xPiece, int yPiece, Player player) {
        super(xPiece, yPiece, player);
    }

    @Override
    public List<Move> possibleMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
        for(int[] possibleMove: POSSIBLE_MOVES){
            int newX = this.xPiece+possibleMove[0];
            int newY = this.yPiece+possibleMove[1];
            addMoveIfValid(newX,newY,possibleMoves,board);
        }
        return Collections.unmodifiableList(possibleMoves);
    }
}
