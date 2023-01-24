package model;

public abstract class Rook extends Piece {
    private Coordinate[] coordinates;
    public Rook(Type type, Cell cell) {
        super(type,cell);
    }
    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = position.up();
        while (check(c)){
            c = c.up();
        }

        //Down
        c = position.down();
        while (check(c)){
            c = c.down();
        }

        //Left
        c = position.left();
        while (check(c)){
            c = c.left();
        }

        //Right
        c = position.right();
        while (check(c)){
            c = c.right();
        }


        return coordinates;
    }

    public boolean check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c) != null){
            if(board.getCell(c).isEmpty()){
                coordinates = Tool.add(coordinates,c);
                return true;
            }
            if(board.getCell(c).getPiece().getColor() != getColor()){
                coordinates = Tool.add(coordinates,c);
                return false;
            }
        }
        return false;
    }
}
