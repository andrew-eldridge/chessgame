/*
    Abstract representation of a chess piece
 */

package chess.pieces;

import chess.Board;
import chess.Position;

public interface Piece {

    String getColor();
    Position getPosition();
    void setColor(String color);
    void setPosition(Position p);
    void move(Position p);
    Position[] getMoves(Board b);
    boolean isOpposing(Piece p);

}
