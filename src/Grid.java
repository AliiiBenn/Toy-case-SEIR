import java.util.ArrayList;
import java.util.List;




public class Grid {
    private List<List<List<Individu>>> grid;

    public Grid() {
        initializeGrid();
    }


    private void initializeGrid() {
        grid = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            List<List<Individu>> row = new ArrayList<>();
            for (int j = 0; j < 300; j++) {
                row.add(new ArrayList<>());
            }
            grid.add(row);
        }
    }

    public void addIndividu(Individu individu, int x, int y) {
        grid.get(x).get(y).add(individu);
    }

    public void removeIndividu(Individu individu, int x, int y) {
        grid.get(x).get(y).remove(individu);
    }

    public List<Individu> getIndividus(int x, int y) {
        return grid.get(x).get(y);
    }

}
