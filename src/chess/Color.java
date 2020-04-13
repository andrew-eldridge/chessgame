/*
    Piece color constants
 */

package chess;

public class Color {

    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String DEFAULT_COLOR = WHITE;

    public static boolean checkValid(String color) {
        return color.equals(WHITE) || color.equals(BLACK);
    }

}
