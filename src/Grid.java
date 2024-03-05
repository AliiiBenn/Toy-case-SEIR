import java.util.ArrayList;



/*
 * 
 * Initialiser la grille avec 20k individus 
 * Ajouter une possibilité de placer un individu aléatoirement sur la grille
 * Récupérer les voisins d'un individu
 * Créer une grille de taille 300x300 avec un nombre non défini d'individus par case
 * Récurer une case aléatoire de la grille
 * 
 */


public class Grid {
    private ArrayList<ArrayList<ArrayList<Individu>>> grid;


    private void initializeGridSize(int size) {
        grid = new ArrayList<ArrayList<ArrayList<Individu>>>();
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<ArrayList<Individu>>());
            for (int j = 0; j < size; j++) {
                grid.get(i).add(new ArrayList<Individu>());
            }
        }
    }

    public Grid(int size) {
        initializeGridSize(size);
    }


    public ArrayList<ArrayList<ArrayList<Individu>>> getGrid() {
        return grid;
    }


    public void addIndividu(Individu individu, int x, int y) {
        grid.get(x).get(y).add(individu);
    }


    public Individu getIndividu(int x, int y, int index) {
        return grid.get(x).get(y).get(index);
    }

    public ArrayList<Individu> getIndividus(int x, int y) {
        return grid.get(x).get(y);
    }



    public int getSize() {
        return grid.size();
    }


    public ArrayList<Individu> getNeighbours(int x, int y, int index) {
        ArrayList<Individu> neighbours = new ArrayList<Individu>();

        for (int yIndex = y - 1; yIndex <= y + 1; yIndex++) {
            for (int xIndex = x - 1; xIndex <= x + 1; xIndex++) {
                this.getIndividus(xIndex, yIndex).forEach((individu) -> {
                    if (individu != this.getIndividu(x, y, index)) {
                        neighbours.add(individu);
                    }
                });
            }
        }

        return neighbours;
    }


}
