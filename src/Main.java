import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(9);

        
        
        grid.addIndividu(new Individu(), 5, 5);

        grid.addIndividu(new Individu(), 4, 4);
        grid.addIndividu(new Individu(), 5, 4);
        grid.addIndividu(new Individu(), 6, 4);

        grid.addIndividu(new Individu(), 4, 5);
        grid.addIndividu(new Individu(), 5, 5);
        grid.addIndividu(new Individu(), 6, 5);

        grid.addIndividu(new Individu(), 4, 6);
        grid.addIndividu(new Individu(), 5, 6);
        grid.addIndividu(new Individu(), 6, 6);        

        for (ArrayList<ArrayList<Individu>> row : grid.getGrid()) {
            System.out.println(row);
        }

        System.out.println();

        System.out.println(grid.getNeighbours(5, 5, 0));
        

        // System.out.println(grid.getIndividu(0, 0, 0));
        // System.out.println(grid.getNeighbours(0, 0, 0));


    }
}

