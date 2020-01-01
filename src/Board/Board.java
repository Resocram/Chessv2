package Board;

import Board.Tile.BlankTile;
import Board.Tile.Tile;

public class Board {
    public Tile getTile(int newX, int newY) {
        return new BlankTile(1,2);
    }
}
