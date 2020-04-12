/*
    Abstract representation of a chess piece
 */

package chess;

public interface Piece {

    String getColor();
    Position getPosition();
    void setColor(String color);
    void setPosition(Position p);
    void move(Position p, Board b);
    Position[] getMoves(Board b);
    boolean isOpposing(Piece p);

}
