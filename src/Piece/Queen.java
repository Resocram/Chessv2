package Piece;

import Board.Board;
import Move.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Queen extends Piece {
    private final static int[][] POSSIBLE_MOVES = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public Queen(int xPiece, int yPiece, Player player) {
        super(xPiece, yPiece, player);
    }

    @Override
    public List<Move> possibleMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
        //Bishop
        int newX = this.xPiece + POSSIBLE_MOVES[0][0];
        int newY = this.yPiece + POSSIBLE_MOVES[0][1];
        while (addMoveIfValid(newX, newY, possibleMoves, board)) {
            newX++;
            newY++;
        }
        newX = this.xPiece + POSSIBLE_MOVES[1][0];
        newY = this.yPiece + POSSIBLE_MOVES[1][1];
        while (addMoveIfValid(newX, newY, possibleMoves, board)) {
            newX++;
            newY--;
        }
        newX = this.xPiece + POSSIBLE_MOVES[2][0];
        newY = this.yPiece + POSSIBLE_MOVES[2][1];
        while (addMoveIfValid(newX, newY, possibleMoves, board)) {
            newX--;
            newY++;
        }
        newX = this.xPiece + POSSIBLE_MOVES[3][0];
        newY = this.yPiece + POSSIBLE_MOVES[3][1];
        while (addMoveIfValid(newX, newY, possibleMoves, board)) {
            newX--;
            newY--;
        }

        //Rook
        newY = this.yPiece + POSSIBLE_MOVES[4][1];
        while (addMoveIfValid(this.xPiece, newY, possibleMoves, board)) {
            newY++;
        }
        newY = this.yPiece + POSSIBLE_MOVES[5][1];
        while (addMoveIfValid(this.xPiece, newY, possibleMoves, board)) {
            newY--;
        }
        newX = this.xPiece + POSSIBLE_MOVES[6][0];
        while (addMoveIfValid(newX, this.yPiece, possibleMoves, board)) {
            newX--;
        }
        newX = this.xPiece + POSSIBLE_MOVES[7][0];
        while (addMoveIfValid(newX, this.yPiece, possibleMoves, board)) {
            newX++;
        }
        return Collections.unmodifiableList(possibleMoves);
    }
}
