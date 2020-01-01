package Piece;

import Board.Board;


import Board.Tile.Tile;
import Move.Move;
import Move.RegularMove;
import Move.AttackingMove;

import java.util.ArrayList;
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
            if(checkValidMove(newX, newY)){
                Tile finalTile = board.getTile(newX, newY);
                if(!finalTile.containsPiece()){
                    possibleMoves.add(new RegularMove(board,this,newX,newY));
                }else{
                    Piece pieceAtFinalTile = finalTile.getPiece();
                    Player playerAtFinalTile = pieceAtFinalTile.getPlayer();
                    if(!playerAtFinalTile.equals(this.player)){
                        possibleMoves.add(new AttackingMove(board, this, newX, newY,pieceAtFinalTile));
                    }
                }

            }
        }
        return possibleMoves;
    }

    @Override
    public boolean checkValidMove(int newX, int newY) {
        return newX >=0 && newX<=7 && newY>=0 && newY<=7;
    }
}
