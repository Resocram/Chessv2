package Tiles;

import Piece.Piece;

public class PieceTile extends Tile {
    private final Piece piece;
    PieceTile(int xCoordinate, int yCoordinate, Piece piece) {
        super(xCoordinate, yCoordinate);
        this.piece = piece;
    }

    @Override
    public boolean containsPiece() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }
}
