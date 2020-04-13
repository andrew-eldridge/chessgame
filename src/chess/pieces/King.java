/*
    King piece
 */

package chess.pieces;

import chess.*;
import chess.errors.InvalidPieceColorError;
import chess.errors.InvalidPiecePositionError;

public class King extends GenericPiece {

    // Constants
    public static final int VALUE = 100;

    // Attributes
    private String color;
    private Position position;

    // Constructor
    public King(String color, Position pos) {
        super(color);
        initPosition(pos);
    }
    private void initPosition(Position pos) throws InvalidPiecePositionError, InvalidPieceColorError {
        if (this.color.equals(Color.WHITE)) {
            if (pos.equals(Position.E1)) {
                this.position = pos;
            } else {
                throw new InvalidPiecePositionError(pos);
            }
        } else if (this.color.equals(Color.BLACK)) {
            if (pos.equals(Position.E8)) {
                this.position = pos;
            } else {
                throw new InvalidPiecePositionError(pos);
            }
        } else {
            // There should be no way to get here...
            throw new InvalidPieceColorError(this.color);
        }
    }

    // Getters
    public String getColor() {
        return super.getColor();
    }
    public Position getPosition() {
        return super.getPosition();
    }

    // Setters
    public void setColor(String color) throws InvalidPieceColorError {
        super.setColor(color);
    }
    public void setPosition(Position pos) throws InvalidPiecePositionError {
        super.setPosition(pos);
    }

    // Move piece to a given position
    public void move(Position pos) {
        super.move(pos);
    }

    // Return an array of available positions
    @Override
    public Position[] getMoves(Board b) {
        // King can move one space in each direction
        Position[] horizontals = Position.getHorizontals(this, b, 1);
        Position[] verticals = Position.getVerticals(this, b, 1);
        Position[] diagonals = Position.getDiagonals(this, b, 1);
        return Position.combinePositionEnumerations(horizontals, verticals, diagonals);
    }

    // Indicates whether given piece is on opposing team
    public boolean isOpposing(Piece p) {
        return super.isOpposing(p);
    }

}
