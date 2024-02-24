import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Grid {
    private ArrayList<ArrayList<ArrayList<Individu>>> grid;



    private void initializeGrid(int lines, int columns) {

    }

    

    public ArrayList<Individu> getIndividus(int line, int column) {
        return grid.get(line).get(column);
    }

    public void addIndividu(Individu individu, int line, int column) {
        grid.get(line).get(column).add(individu);
    }

    public void removeIndividu(int line, int column, int index) {
        grid.get(line).get(column).remove(index);
    }

    public void moveIndividu(int line, int column, int index, int newLine, int newColumn) {
        Individu individu = grid.get(line).get(column).get(index);
        grid.get(line).get(column).remove(index);
        grid.get(newLine).get(newColumn).add(individu);
    }


    public static Grid createGrid(int lines, int columns) {
        Grid grid = new Grid();
        
        return grid;
    }

}
