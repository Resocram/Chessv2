package Tiles;

import Piece.Piece;
import Piece.Player;

public class PieceTile extends Tile {
    private final Piece piece;
    PieceTile(int xCoordinate, int yCoordinate, Piece piece) {
        super(xCoordinate, yCoordinate);
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (this.piece.getPlayer().equals(Player.BLACK)) {
            return this.piece.toString().toLowerCase();
        }else{
            return this.piece.toString();
        }
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
