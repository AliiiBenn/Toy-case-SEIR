import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(300);

        
        for (int i = 0; i < 20000; i++) {
            Individu individu = new Individu();
            grid.addIndividu(individu, (int) (Math.random() * 300), (int) (Math.random() * 300));
        }
        



        for (ArrayList<ArrayList<Individu>> row : grid.getGrid()) {
            System.out.println(row);
        }

        System.out.println();

  


    }
}

