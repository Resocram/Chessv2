package Tiles;

import Piece.Piece;

public abstract class Tile {
    private int xCoordinate;
    private int yCoordinate;

    protected Tile(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Tile createTile(int xTile, int yTile, Piece piece){
        if(piece==null){
            return new BlankTile(xTile,yTile);
        }
        else{
            return new PieceTile(xTile,yTile,piece);
        }
    }

    public abstract String toString();
    public abstract boolean containsPiece();
    public abstract Piece getPiece();


}
