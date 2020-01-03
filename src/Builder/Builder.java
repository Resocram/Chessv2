package Builder;

import Piece.Piece;
import Piece.Player;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Builder {
    private Map<Pair<Integer, Integer>, Piece> boardConfig;
    private Player nextMove;

    public Builder(){
        this.boardConfig = new HashMap<>();
    }

    public Player getNextMove() {
        return nextMove;
    }

    public Map<Pair<Integer, Integer>, Piece> getBoardConfig() {
        return boardConfig;
    }

    public Builder setPiece(Piece piece){
        int xPiece = piece.getxPiece();
        int yPiece = piece.getyPiece();
        Pair<Integer, Integer> pair = new Pair<>(xPiece,yPiece);
        this.boardConfig.put(pair,piece);
        return this;
    }

    public Builder setMoveMaker(Player nextMove){
        this.nextMove = nextMove;
        return this;
    }

    public Board build(){
        return new Board(this);
    }
}
