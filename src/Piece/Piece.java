package Piece;

import Builder.Board;
import Tiles.Tile;
import Move.Move;
import Move.RegularMove;
import Move.AttackingMove;

import java.util.List;

public abstract class Piece {
    protected final int xPiece;
    protected final int yPiece;
    protected final Player player;
    protected final boolean isFirstMove;

    public Piece(int xPiece, int yPiece, Player player) {
        this.player = player;
        this.xPiece = xPiece;
        this.yPiece = yPiece;
        this.isFirstMove = false;
    }

    public int getxPiece() {
        return xPiece;
    }

    public int getyPiece(){
        return yPiece;
    }

    public abstract List<Move> possibleMoves(Board board);


    public Player getPlayer(){
        return this.player;
    }
    public boolean checkValidMove(int newX, int newY){
        return newX >=0 && newX<=7 && newY>=0 && newY<=7;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }


    public boolean addMoveIfValid(int newX, int newY, List<Move> possibleMoves, Board board) {
        if (checkValidMove(newX, newY)) {
            Tile finalTile = board.getTile(newX, newY);
            if (!finalTile.containsPiece()) {
                possibleMoves.add(new RegularMove(board, this, newX, newY));
                return true;
            } else {
                Piece pieceAtFinalTile = finalTile.getPiece();
                Player playerAtFinalTile = pieceAtFinalTile.getPlayer();
                if (!playerAtFinalTile.equals(this.player)) {
                    possibleMoves.add(new AttackingMove(board, this, newX, newY, pieceAtFinalTile));
                    return true;
                }
                else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }

    public enum PieceType{
        PAWN("P"),
        KNIGHT("N"),
        BISHOP("B"),
        ROOK("R"),
        QUEEN("Q"),
        KING("K");


        private String pieceName;
        PieceType(String pieceName){
            this.pieceName = pieceName;
        }

        @Override
        public String toString(){
            return this.pieceName;
        }


    }


}
