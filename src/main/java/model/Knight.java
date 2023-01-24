package model;

public abstract class Knight extends Piece{

    private Coordinate[] coordinates;
    public Knight(Type type, Cell cell) {
        super(type,cell);
    }
    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = position.up().upL();
        check(c);
        c = position.up().upR();
        check(c);
        //Down
        c = position.down().downL();
        check(c);
        c = position.down().downR();
        check(c);
        //Right
        c = position.right().upR();
        check(c);
        c = position.right().downR();
        check(c);
        //Left
        c = position.left().upL();
        check(c);
        c = position.left().downL();
        check(c);

        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c) != null){
            if(board.getCell(c).isEmpty() || board.getCell(c).getPiece().getColor() != getColor())
                coordinates = Tool.add(coordinates,c);
        }
    }



}
