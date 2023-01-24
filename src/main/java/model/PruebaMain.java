package model;

public class PruebaMain {
    public static void main(String[] args) {
        Board b1 = new Board();

        b1.placePieces();
        System.out.print(b1);

        Coordinate[] coordinates = b1.getCell(new Coordinate('C',8)).getPiece().getNextMovements();
        b1.highlight(coordinates);
        System.out.println(b1);
    }
}
