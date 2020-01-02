package Builder;

import Piece.*;
import Tiles.Tile;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;

public class Board {
    private final Tile[][] gameBoard;
    public Board(Builder builder) {
        this.gameBoard = createGameBoard(builder);
    }

    private Tile[][] createGameBoard(Builder builder){
        Tile[][] tiles = new Tile[8][8];
        for(int i =0; i<8;i++){
            for(int j=0; j<8;j++){
                Pair<Integer, Integer> pair = new Pair<>(i,j);
                tiles[i][j] = Tile.createTile(i,j,builder.getBoardConfig().get(pair));
            }
        }
        return tiles;
    }

    public Board createStandardBoard(){
        Builder builder = new Builder();
        builder.setPiece(new Rook(0,7,Player.BLACK));
        builder.setPiece(new Knight(1,7,Player.BLACK));
        builder.setPiece(new Bishop(2,7,Player.BLACK));
        builder.setPiece(new Queen(3,7,Player.BLACK));
        builder.setPiece(new King(4,7,Player.BLACK));
        builder.setPiece(new Bishop(5,7,Player.BLACK));
        builder.setPiece(new Knight(6,7,Player.BLACK));
        builder.setPiece(new Rook(7,7,Player.BLACK));
        builder.setPiece(new Pawn(0,6,Player.BLACK));
        builder.setPiece(new Pawn(1,6,Player.BLACK));
        builder.setPiece(new Pawn(2,6,Player.BLACK));
        builder.setPiece(new Pawn(3,6,Player.BLACK));
        builder.setPiece(new Pawn(4,6,Player.BLACK));
        builder.setPiece(new Pawn(5,6,Player.BLACK));
        builder.setPiece(new Pawn(6,6,Player.BLACK));
        builder.setPiece(new Pawn(7,6,Player.BLACK));

        builder.setPiece(new Rook(0,0,Player.WHITE));
        builder.setPiece(new Knight(1,0,Player.WHITE));
        builder.setPiece(new Bishop(2,0,Player.WHITE));
        builder.setPiece(new Queen(3,0,Player.WHITE));
        builder.setPiece(new King(4,0,Player.WHITE));
        builder.setPiece(new Bishop(5,0,Player.WHITE));
        builder.setPiece(new Knight(6,0,Player.WHITE));
        builder.setPiece(new Rook(7,0,Player.WHITE));
        builder.setPiece(new Pawn(0,6,Player.WHITE));
        builder.setPiece(new Pawn(1,6,Player.WHITE));
        builder.setPiece(new Pawn(2,6,Player.WHITE));
        builder.setPiece(new Pawn(3,6,Player.WHITE));
        builder.setPiece(new Pawn(4,6,Player.WHITE));
        builder.setPiece(new Pawn(5,6,Player.WHITE));
        builder.setPiece(new Pawn(6,6,Player.WHITE));
        builder.setPiece(new Pawn(7,6,Player.WHITE));

        builder.setMoveMaker(Player.WHITE);

        return builder.build();

    }



    public Tile getTile(int newX, int newY) {
        return null;
    }

}
