package Piece;

import Builder.Board;
import Move.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rook extends Piece {
    private final static int[][] POSSIBLE_MOVES = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public Rook(int xPiece, int yPiece, Player player) {
        super(xPiece, yPiece, player);
    }

    @Override
    public List<Move> possibleMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
        int newY = this.yPiece + POSSIBLE_MOVES[0][1];
        while (addMoveIfValid(this.xPiece, newY, possibleMoves, board)) {
            newY++;
        }
        newY = this.yPiece + POSSIBLE_MOVES[1][1];
        while (addMoveIfValid(this.xPiece, newY, possibleMoves, board)) {
            newY--;
        }
        int newX = this.xPiece + POSSIBLE_MOVES[2][0];
        while (addMoveIfValid(newX, this.yPiece, possibleMoves, board)) {
            newX--;
        }
        newX = this.xPiece + POSSIBLE_MOVES[3][0];
        while (addMoveIfValid(newX, this.yPiece, possibleMoves, board)) {
            newX++;
        }

        return Collections.unmodifiableList(possibleMoves);
    }
    @Override
    public String toString(){
        return PieceType.ROOK.toString();
    }
}
