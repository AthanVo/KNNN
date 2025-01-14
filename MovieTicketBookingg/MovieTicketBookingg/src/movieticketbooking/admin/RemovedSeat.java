
package movieticketbooking.admin;


public class RemovedSeat {
    private int colIndex;
    private int rowIndex;

    public RemovedSeat(int col,int row) {
        colIndex=col;
        rowIndex=row;
    }
    public int getCol(){
        return colIndex;
    }
     public int getRow(){
        return rowIndex;
    }
    
}
