package Piece;

import Builder.Board;
import Move.Move;
import Move.RegularMove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pawn extends Piece {
    private final static int[][] POSSIBLE_MOVES = {{0, 1}, {0, 2},{-1,1},{1,1}};

    public Pawn(int xPiece, int yPiece, Player player) {
        super(xPiece, yPiece, player);
    }

    @Override
    public List<Move> possibleMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
        for (int[] possibleMove : POSSIBLE_MOVES) {
            int newX = this.xPiece + possibleMove[0];
            int newY = this.yPiece + possibleMove[1] * player.getDirection();
            if (checkValidMove(newX, newY) && possibleMove[0] == 0 && possibleMove[1] == 1) {
                if (!board.getTile(newX, newY).containsPiece()) {
                    possibleMoves.add(new RegularMove(board, this, newX, newY));
                }
            } else if (checkValidMove(newX, newY) && Math.abs(possibleMove[1]) == 2 && isFirstMove()) {
                if ((this.yPiece == 1 && player.getDirection() == 1) || (this.yPiece == 6 && player.getDirection() == -1)) {
                    boolean jumpingOver = board.getTile(newX, newY - player.getDirection()).containsPiece();
                    if (!jumpingOver) {
                        if (!board.getTile(newX, newY).containsPiece()) {
                            possibleMoves.add(new RegularMove(board, this, newX, newY));
                        }
                    }

                }
            } else {
                if(checkValidMove(newX, newY)) {
                    if (board.getTile(newX, newY).containsPiece()) {
                        Piece pieceToAttack = board.getTile(newX, newY).getPiece();
                        if (pieceToAttack.player != this.player) {
                            possibleMoves.add(new RegularMove(board, this, newX, newY));
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(possibleMoves);
    }
}
