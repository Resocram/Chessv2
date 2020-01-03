package ChessPlayer;

import Builder.Board;
import Move.Move;
import Piece.King;
import Piece.Piece;
import Piece.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPlayer {

    protected final Board board;
    protected final King playerKing;
    protected final List<Move> legalMoves;
    private boolean isInCheck;

    public ChessPlayer(Board board, List<Move> legalMoves, List<Move> opponentMoves){
        this.board = board;
        this.playerKing = makeKing();
        this.legalMoves = legalMoves;
        this.isInCheck = calculateAttacksOnTile(this.playerKing.getxPiece(),this.playerKing.getyPiece(),opponentMoves).isEmpty();
    }

    private List<Move> calculateAttacksOnTile(int xPiece, int yPiece, List<Move> moves){
        List<Move> attackMoves = new ArrayList<>();
        for(Move move: moves){
            if(xPiece==move.getX() && yPiece==move.getY()){
                attackMoves.add(move);
            }
        }
        return attackMoves;
    }

    public King getPlayerKing() {
        return playerKing;
    }

    private King makeKing(){
        for(Piece piece: getPieces()){
            if(piece.getPieceType().isKing()){
                return (King) piece;
            }
        }
        throw new RuntimeException("No King");
    }

    public boolean isMoveLegal(final Move move){
        return this.legalMoves.contains(move);
    }

    public boolean isInCheck(){
        return this.isInCheck;
    }

    public boolean isInCheckMate(){
        return this.isInCheck && !hasEscapeMoves();
    }

    protected boolean hasEscapeMoves(){
        for(Move move: this.legalMoves){
            MoveTransition transition = makeMove(move);
            if(transition.getMoveStatus().isDone()){
                return true;
            }
        }
        return false;
    }

    public boolean isInStaleMate(){
        return !this.isInCheck && !hasEscapeMoves();
    }

    public boolean isCastled(){
        return false;
    }

    public List<Move> getLegalMoves(){
        return this.legalMoves;
    }

    public MoveTransition makeMove(Move move){
        if(!isMoveLegal(move)){
            return new MoveTransition(this.board,move,MoveStatus.ILLEGAL_MOVE);
        }
        Board transitionBoard = move.execute();
        King king = transitionBoard.currentPlayer().getOpponent().getPlayerKing();
        List<Move> kingAttacks = this.calculateAttacksOnTile(king.getxPiece(),king.getyPiece(),board.currentPlayer().getLegalMoves());
        if(!(kingAttacks.isEmpty())){
            return new MoveTransition(this.board,move,MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        return new MoveTransition(this.board,move,MoveStatus.DONE);
    }

    public abstract List<Piece> getPieces();
    public abstract Player getPlayer();
    public abstract ChessPlayer getOpponent();


}
