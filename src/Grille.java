import java.util.ArrayList;



// ? Le fonctionnement pourrait être que pour chaque individu :
// ? - Si l'individu est susceptible, on regarde s'il a des voisins infectés. Si c'est le cas, on le passe en état exposé.
// ? - Sinon, on modifie le temps d'exposition de l'individu. 
// ? - On déplace l'individu dans une liste aléatoire de la grille.






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

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < lignes && j >= 0 && j < colonnes) {
                    voisins.addAll(grille.get(i).get(j).getIndividus());
                }
            }
        }
        
        return voisins;
    }

    /**
     * 
     * @param voisins Une liste d'individus qui représente les voisins d'un individu
     * @return boolean true si un individu parmi la liste des voisins est infecté, false sinon
     * 
     */
    public boolean isVoisinInfecte(ArrayList<Individu> voisins) {
        Individus individus = Individus.createIndividusFromArray(voisins);

        return individus.isSomeoneInfected();
    }

    
    /**
     * Déplace un individu d'une liste d'individus à une autre liste d'individus
     * 
     * @param individu L'individu que l'on veut déplacer
     * @param individusOrigine La liste d'individus d'origine de l'individu
     * @param individusDestination La liste d'individus de destination de l'individu
     * 
     */
    public void deplacerIndividu(Individu individu, Individus individusOrigine, Individus individusDestination) {
        individusOrigine.removeIndividu(individu);
        individusDestination.addNewIndividu(individu);
    }

    /**
     * Méthode utilitaire pour sélectionner une liste d'individus aléatoire de la grille
     * 
     * 
     * @return Individus Une liste d'individus aléatoire de la grille
     * 
     */
    public Individus selectionnerListeAleatoire() {
        // TODO: Mettre dans une classe utilitaire
        MTRandom generateurAleatoire = new MTRandom();

        return grille.get(generateurAleatoire.next(16) % 299).get(generateurAleatoire.next(16) % 299);
    }


    /**
     * Ajoute un individu à une liste d'individus aléatoire de la grille
     * 
     * @param individu L'individu que l'on veut ajouter
     * 
     */
    public void ajouterIndividu(Individu individu, int x, int y) {
        grille.get(x).get(y).addNewIndividu(individu);
    }

    public Individus getIndividus(int x, int y) {
        return grille.get(x).get(y);
    }


    /**
     * 
     * @param lignes Le nombre de lignes de la grille
     * @param colonnes Le nombre de colonnes de la grille
     * @return Grille La grille d'individus vide
     * 
     */
    public static Grille creerGrille(int lignes, int colonnes) {
        Grille grille = new Grille(lignes, colonnes);
        return grille;
    }
}