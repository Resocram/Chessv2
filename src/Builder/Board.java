package Builder;

import ChessPlayer.ChessPlayer;
import ChessPlayer.whitePlayer;
import Move.Move;
import Piece.*;
import Tiles.Tile;
import ChessPlayer.whitePlayer;
import ChessPlayer.blackPlayer;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final Tile[][] gameBoard;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    private final whitePlayer whitePlayer;
    private final blackPlayer blackPlayer;
    private final ChessPlayer currentPlayer;

    public Board(Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = calculateActivePieces(this.gameBoard,Player.WHITE);
        this.blackPieces = calculateActivePieces(this.gameBoard,Player.BLACK);

        List<Move> whiteLegalMoves = calculateLegalMoves(this.whitePieces);
        List<Move> blackLegalMoves = calculateLegalMoves(this.blackPieces);

        this.whitePlayer = new whitePlayer(this,whiteLegalMoves,blackLegalMoves);
        this.blackPlayer = new blackPlayer(this,whiteLegalMoves,blackLegalMoves);
        this.currentPlayer = builder.getNextMove().choosePlayer(this.whitePlayer,this.blackPlayer);

    }

    public ChessPlayer currentPlayer(){
        return this.currentPlayer;
    }
    public ChessPlayer whitePlayer(){
        return this.whitePlayer;
    }

    public ChessPlayer blackPlayer(){
        return this.blackPlayer;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i =7; i>=0;i--){
            for(int j = 0; j<=7; j++){
                String tileText = this.gameBoard[j][i].toString();
                builder.append((String.format("%3s",tileText)));
            }
            builder.append("\n");
        }
        return builder.toString();
    }




    private List<Move> calculateLegalMoves(List<Piece> pieces){
        List<Move> legalMoves = new ArrayList<>();
        for(Piece piece: pieces){
            legalMoves.addAll(piece.possibleMoves(this));
        }
        return Collections.unmodifiableList(legalMoves);
    }

    private List<Piece> calculateActivePieces (Tile[][] gameBoard, Player player){
        List<Piece> activePieces = new ArrayList<Piece>();
        for(int i =0; i<8;i++){
            for(int j =0; j<8;j++){
                if(gameBoard[i][j].containsPiece()){
                    if(gameBoard[i][j].getPiece().getPlayer().equals(player)){
                        activePieces.add(gameBoard[i][j].getPiece());
                    }
                }
            }
        }
        return activePieces;
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

    public static Board createStandardBoard(){
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
        builder.setPiece(new Pawn(0,1,Player.WHITE));
        builder.setPiece(new Pawn(1,1,Player.WHITE));
        builder.setPiece(new Pawn(2,1,Player.WHITE));
        builder.setPiece(new Pawn(3,1,Player.WHITE));
        builder.setPiece(new Pawn(4,1,Player.WHITE));
        builder.setPiece(new Pawn(5,1,Player.WHITE));
        builder.setPiece(new Pawn(6,1,Player.WHITE));
        builder.setPiece(new Pawn(7,1,Player.WHITE));

        builder.setMoveMaker(Player.WHITE);

        return builder.build();

    }



    public Tile getTile(int newX, int newY) {
        return gameBoard[newX][newY];
    }

}
