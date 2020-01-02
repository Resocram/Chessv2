package Piece;

import Board.Board;
import Board.Tile.Tile;
import Move.Move;
import Move.RegularMove;
import Move.AttackingMove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bishop extends Piece {
    private final static int[][] POSSIBLE_MOVES = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public Bishop(int xPiece, int yPiece, Player player) {
        super(xPiece, yPiece, player);
    }

    @Override
    public List<Move> possibleMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
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

        return Collections.unmodifiableList(possibleMoves);
    }

}