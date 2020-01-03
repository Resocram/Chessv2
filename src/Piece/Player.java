package Piece;

import ChessPlayer.ChessPlayer;
import ChessPlayer.whitePlayer;
import ChessPlayer.blackPlayer;

public enum Player {
    WHITE {
        public int getDirection(){
            return 1;
        }
        public ChessPlayer choosePlayer(whitePlayer whitePlayer, blackPlayer blackPlayer){
            return whitePlayer;
        }
    },
    BLACK{
        public int getDirection(){
            return -1;
        }
        public ChessPlayer choosePlayer(whitePlayer whitePlayer, blackPlayer blackPlayer){
            return blackPlayer;
        }
    };
    public abstract int getDirection();
    public abstract ChessPlayer choosePlayer(whitePlayer whitePlayer, blackPlayer blackPlayer);
}
