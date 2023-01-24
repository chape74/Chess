package model;

public abstract class Bishop extends Piece {
    private Coordinate[] coordinates;
    public Bishop(Type type, Cell cell) {
        super(type,cell);
    }
    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //UpR
        c = position.upR();
        while (check(c)){
            c = c.upR();
        }

        //DownR
        c = position.downR();
        while (check(c)){
            c = c.downR();
        }

        //UpL
        c = position.upL();
        while (check(c)){
            c = c.upL();
        }

        //DownL
        c = position.downL();
        while (check(c)){
            c = c.downL();
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
