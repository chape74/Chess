package model;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    private Type type;

    private Cell cell;

    public Piece(Type type,Cell cell){
        this.cell = cell;
        this.type = type;
    }

    public abstract Coordinate[] getNextMovements();

    @Override
    public String toString(){
        return colorize(type.getShape(),type.getColor().getPieceColor());
    }

    public enum Color {
        WHITE(Attribute.TEXT_COLOR(50)),

        BLACK(Attribute.TEXT_COLOR(0));


        private Attribute pieceColor;

        private Color(Attribute pieceColor) {
            this.pieceColor = pieceColor;
        }

        public Attribute getPieceColor() {
            return pieceColor;
        }

        public Color next() {
            return this.equals(WHITE) ? BLACK : WHITE;
        }
    }

    public enum Type {

        WHITE_KING("♔",Color.WHITE),
        WHITE_QUEEN("♕",Color.WHITE),
        WHITE_ROOK("♖",Color.WHITE),
        WHITE_BISHOP("♗",Color.WHITE),
        WHITE_KNIGHT("♘",Color.WHITE),
        WHITE_PAWN("♙",Color.WHITE),
        BLACK_KING("♚",Color.BLACK),
        BLACK_QUEEN("♛",Color.BLACK),
        BLACK_ROOK("♜",Color.BLACK),
        BLACK_BISHOP("♝",Color.BLACK),
        BLACK_KNIGHT("♞",Color.BLACK),
        BLACK_PAWN("♟",Color.BLACK);

        private String shape;

        private Color color;

        Type(String shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public String getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }
    }
}
