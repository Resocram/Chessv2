package Piece;

import Builder.Board;


import Move.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Knight extends Piece{
    private final static int[][] POSSIBLE_MOVES = {{-2,-1},{-2,1},{-1,-2},{-1,2},{2,1},{2,-1},{1,2},{1,-2}};
    public Knight(int xPiece, int yPiece, Player player) {
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
