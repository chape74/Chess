package model;

import java.util.Arrays;
import java.util.WeakHashMap;

public class Board {
    private Cell[][] cells;

    public Board(){
        cells = new Cell[8][8];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(this,new Coordinate((char)(j+'A'),i+1));
            }
        }
    }

    public Cell getCell(Coordinate coordinate){
        if(coordinate.getRow()<1 || coordinate.getRow()>8)
            return null;
        if(coordinate.getColumn()<'A' || coordinate.getColumn()>'H')
            return null;
        return cells[coordinate.getRow()-1][coordinate.getColumn()-'A'];
    }


    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";

        for (int i = 0; i < cells.length; i++) {
            output += i+1 +" ";
            for (int j = 0; j < cells.length; j++) {
                output += cells[i][j];
            }
            output += " " + (i+1) +"\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }

    public void placePieces(){
        Piece p;
        p = new KnightWhite(getCell((new Coordinate('B',8))));
        p.putInYourPlace();
        p = new KnightWhite(getCell((new Coordinate('C',3))));
        p.putInYourPlace();
        p = new KnightBlack(getCell((new Coordinate('F',8))));
        p.putInYourPlace();
        p = new RookWhite(getCell((new Coordinate('C',8))));
        p.putInYourPlace();
        p = new BishopWhite(getCell((new Coordinate('E',5))));
        p.putInYourPlace();


    }

    public void resetColors(){
        for (Cell[] row: cells) {
            for(Cell c : row){
                c.resetColor();
            }
        }
    }

    public void highlight(Coordinate[] coordinates) {
        for (Coordinate c:
             coordinates) {
            getCell(c).highlight();
        }
    }
}
