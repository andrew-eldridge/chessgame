/*
    Generic representation of a chess piece
 */

package chess.pieces;

import chess.*;
import chess.errors.InvalidPieceColorError;
import chess.errors.InvalidPiecePositionError;

public class GenericPiece implements Piece {

    // Attributes
    private String color;
    private Position position;

    // Constructor
    public GenericPiece(String color) {
        // Override in child classes to set position
        setColor(color);
    }

    // Getters
    public String getColor() {
        return color;
    }
    public Position getPosition() {
        return position;
    }

    // Setters
    public void setColor(String color) throws InvalidPieceColorError {
        if (Color.checkValid(color)) {
            this.color = color;
        } else {
            throw new InvalidPieceColorError(color);
        }
    }
    public void setPosition(Position pos) throws InvalidPiecePositionError {
        if (pos.isValid()) {
            this.position = pos;
        } else {
            throw new InvalidPiecePositionError(pos);
        }
    }

    // Move piece to a given position
    public void move(Position pos) {
        setPosition(pos);
    }

    // Return an array of available
    public Position[] getMoves(Board b) {
        // Override in child classes
        return new Position[]{};
    }

    // Indicates whether given piece is on opposing team
    public boolean isOpposing(Piece p) {
        return !this.color.equals(p.getColor());
    }

}
