package model;

public class Coordinate {
    private char column;
    private int row;

    public Coordinate(char column, int row) {
        this.column = Character.toUpperCase(column);
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Coordinate up() {
        return new Coordinate(column, row -1);
    }

    public Coordinate upR() {
        return up().right();
    }

    public Coordinate upL() {
         return up().left();
    }

    public Coordinate down() {
        return new Coordinate(column, row +1);
    }

    public Coordinate downR() {
         return down().right();
    }

    public Coordinate downL() {
        return down().left();
    }
    public Coordinate left() {
        return new Coordinate((char)(column -1), row);
    }

    public Coordinate right() {
        return new Coordinate((char)(column +1), row);
    }


    @Override
    public String toString() {
        return "("+ column + row + ")";
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) o;
        return getColumn() == other.getColumn() && row == other.row;
    }
}

