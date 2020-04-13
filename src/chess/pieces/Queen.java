/*
    Queen piece
 */

package chess.pieces;

import chess.*;
import chess.errors.InvalidPieceColorError;
import chess.errors.InvalidPiecePositionError;

public class Queen extends GenericPiece {

    // Constants
    public static final int VALUE = 9;

    // Attributes
    private String color;
    private Position position;

    // Constructor
    public Queen(String color, Position pos) {
        super(color);
        initPosition(pos);
    }
    private void initPosition(Position pos) throws InvalidPiecePositionError, InvalidPieceColorError {
        if (this.color.equals(Color.WHITE)) {
            if (pos.equals(Position.D1) || pos.getY() == 0) {
                setPosition(pos);
            } else {
                throw new InvalidPiecePositionError(pos);
            }
        } else if (this.color.equals(Color.BLACK)) {
            if (pos.equals(Position.D8) || pos.getY() == 7) {
                setPosition(pos);
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
        // Queen can move horizontally, vertically, and diagonally
        Position[] horizontals = Position.getHorizontals(this, b);
        Position[] verticals = Position.getVerticals(this, b);
        Position[] diagonals = Position.getDiagonals(this, b);
        return Position.combinePositionEnumerations(horizontals, verticals, diagonals);
    }

    // Indicates whether given piece is on opposing team
    public boolean isOpposing(Piece p) {
        return super.isOpposing(p);
    }

}
