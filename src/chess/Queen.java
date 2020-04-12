/*
    Queen piece
 */

package chess;

import javax.lang.model.type.ErrorType;
import java.util.Map;

public class Queen implements Piece {

    // Constants
    public static final int VALUE = 9;

    // Attributes
    private String color;
    private Position position;

    // Constructor
    public Queen(String color) throws InvalidPieceColorError {
        setColor(color);
        if (color.equals(Color.WHITE)) {
            setPosition(Position.D1);
        } else if (color.equals(Color.BLACK)) {
            setPosition(Position.D8);
        } else {
            throw new InvalidPieceColorError(color);
        }
    }

    // Getters
    public String getColor() {
        return color;
    }
    public Position getPosition() {
        return position;
    }

    // Setters
    public void setColor(String color) {
        this.color = color;
    }
    public void setPosition(Position pos) {
        this.position = pos;
    }

    // Move piece to a given position
    public void move(Position pos, Board b) {
        Map<Position, Piece> state = b.getBoardState();
    }

    // Return an array of available
    public Position[] getMoves(Board b) {
        // Queen can move horizontally, vertically, and diagonally
        Position[] horizontals = Position.getHorizontals(this, b);
        Position[] verticals = Position.getVerticals(this, b);
        Position[] diagonals = Position.getDiagonals(this, b);
        return Position.combinePositionEnumerations(horizontals, verticals, diagonals);
    }

    // Indicates whether given piece is on opposing team
    public boolean isOpposing(Piece p) {
        return this.color.equals(p.getColor());
    }

}
