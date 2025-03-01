import java.util.ArrayList;







public final class Grille {
    private ArrayList<ArrayList<Individus>> grille;
    private int lignes;
    private int colonnes;


    private Grille(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;

        grille = new ArrayList<>(lignes);

        for (int i = 0; i < lignes; i++) {
            grille.add(new ArrayList<>(colonnes));

            for (int j = 0; j < colonnes; j++) {
                grille.get(i).add(new Individus());
            }
        }
    }

    public ArrayList<ArrayList<Individus>> getGrille() {
        return grille;
    }


    /**
     * 
     * @param x L'indice de la ligne des individus que l'on veut 
     * @param y L'indice de la colonne des individus que l'on veut
     * @return ArrayList<Individu> La liste des individus voisins de la case (x, y). On renvoie une liste qui contient tous les individus des cases voisines de la case (x, y).
     * @throws IndexOutOfBoundsException Si les indices x et y sont en dehors de la grille
     * 
     */
    public ArrayList<Individu> getVoisins(int x, int y) {
        if (x < 0 || x >= lignes || y < 0 || y >= colonnes) {
            throw new IndexOutOfBoundsException("Les indices x et y doivent être compris entre 0 et " + (lignes - 1) + " pour x et " + (colonnes - 1) + " pour y.");
        }

        ArrayList<Individu> voisins = new ArrayList<Individu>();

        int i = x < 1 ? 0 : x - 1;
        int j = y < 1 ? 0 : y - 1;

        int maxI = x >= lignes - 1 ? lignes - 1 : x + 1;
        int maxJ = y >= colonnes - 1 ? colonnes - 1 : y + 1;

        for (; i <= maxI; i++) {
            for (; j <= maxJ; j++) {
                if (i >= 0 && i < lignes && j >= 0 && j < colonnes) {
                    voisins.addAll(grille.get(i).get(j).getIndividus());
                }
            }
        }
        
        return voisins;
    }


    public boolean isVoisinInfecte(ArrayList<Individu> voisins) {
        Individus individus = Individus.createIndividusFromArray(voisins);

        return individus.isSomeoneInfected();
    }

    
    public void deplacerIndividu(Individu individu, Individus individusOrigine, Individus individusDestination) {
        individusOrigine.removeIndividu(individu);
        individusDestination.addNewIndividu(individu);
    }

    public Individus selectionnerListeAleatoire() {
        // TODO: Mettre dans une classe utilitaire
        MTRandom generateurAleatoire = new MTRandom();

        return grille.get(generateurAleatoire.next(16) % 299).get(generateurAleatoire.next(16) % 299);
    }

    public void ajouterIndividu(Individu individu, int x, int y) {
        grille.get(x).get(y).addNewIndividu(individu);
    }

    public Individus getIndividus(int x, int y) {
        return grille.get(x).get(y);
    }

    public static Grille creerGrille(int lignes, int colonnes) {
        Grille grille = new Grille(lignes, colonnes);
        return grille;
    }
}