/*
    Abstract representation of a chess piece
 */

public interface Piece {

    String getColor();
    Position getPosition();
    void setColor(String color);
    void setPosition(Position p);
    void move(Position p);
    Position[] getMoves(Board b);

}
