package model;

import com.diogonunes.jcolor.Attribute;

import javax.swing.text.Highlighter;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {
    private Piece piece;

    private Board board;

    private Coordinate coordinate;

    private Color original;

    private Color color;

    public Cell(Board board, Coordinate coordinate) {
        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;
        this.original = ((coordinate.getRow()-1+coordinate.getColumn()-'A')%2 == 0) ? Color.WHITE_CELL : Color.BLACK_CELL;
        this.color = original;
    }

    public Piece getPiece() {
        return piece;
    }

    public Board getBoard() {
        return board;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void resetColor() {
        color = original;
    }

    public void highlight() {
        if (original == Color.BLACK_CELL){
            if (isEmpty()) this.color = Color.HIGHLIGHT_BLACK;
            else this.color = Color.HIGHLIGHT_KILL_BLACK;
        } else {
            if (isEmpty()) this.color = Color.HIGHLIGHT_BLACK;
            else this.color = Color.HIGHLIGHT_KILL_BLACK;
        }


    }

    @Override
    public String toString() {
        if (getPiece()==null) return colorize("   ", color.getAttribute());
        return colorize(" "+getPiece().toString(), color.getAttribute()) + colorize(" ", color.getAttribute());
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    enum Color{

        WHITE_CELL(Attribute.BACK_COLOR(180,180,180)),
        BLACK_CELL(Attribute.BACK_COLOR(100,100,100)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180,0,0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130,0,0)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180,180,0)),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130,130,0));

        private final Attribute attribute;

        Color(Attribute attribute) {
            this.attribute = attribute;
        }

        public Attribute getAttribute() {
            return attribute;
        }
    }
}
