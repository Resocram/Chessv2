package Tiles;

import Piece.Piece;

public class BlankTile extends Tile {

    BlankTile(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public boolean containsPiece() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
