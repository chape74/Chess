package model;

import java.util.Arrays;

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
}
