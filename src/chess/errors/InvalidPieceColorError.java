/*
    Error to be thrown when a piece is initialized with an invalid color
 */

package chess.errors;

public class InvalidPieceColorError extends Error {

    public InvalidPieceColorError() {
        super("Invalid color given for piece.");
    }
    public InvalidPieceColorError(String color) {
        super(String.format("Invalid color given for piece: %s", color));
    }

}
