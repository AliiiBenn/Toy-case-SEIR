import java.util.ArrayList;


// TODO: Avoir la possibilité de récupérer les voisins d'une liste d'individus
// TODO: Ajouter le système de déplacement d'un individu précis d'une liste. On peut stocker temporairement l'individu dans une variable temporaire puis l'affecter à une autre liste tout en le supprimant de la liste d'origine. 

// ? Le fonctionnement pourrait être que pour chaque individu :
// ? - Si l'individu est susceptible, on regarde s'il a des voisins infectés. Si c'est le cas, on le passe en état exposé.
// ? - Sinon, on modifie le temps d'exposition de l'individu. 
// ? - On déplace l'individu dans une liste aléatoire de la grille.


// TODO: Créer une méthode qui récupère les voisins d'une liste d'individus (la liste actuelle est aussi incluse)
// TODO: Créer une méthode pour vérifier si un individu parmi une liste d'individus est infecté
// TODO: Créer une méthode pour déplacer un individu d'une liste à une autre
// TODO: Créer une méthode pour selectionner une liste aléatoire de la grille


// TODO: Créer une méthode qui crée une grille d'individus vide (sans individus) avec une taille donnée
// TODO: Créer une méthode pour ajouter un individu à une liste d'individus aléatoire de la grille


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


    public ArrayList<Individu> getVoisins(int x, int y) {
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

    public boolean isVoisinInfecte(ArrayList<Individu> voisins) {
        Individus individus = Individus.createIndividus(voisins);

        return individus.isSomeoneInfected();
    }

    public void deplacerIndividu(Individu individu, Individus individusOrigine, Individus individusDestination) {
        individusOrigine.removeIndividu(individu);
        individusDestination.addNewIndividu(individu);
    }

    public Individus selectionnerListeAleatoire() {
        MTRandom generateurAleatoire = new MTRandom();

        return grille.get(generateurAleatoire.next(16) % 299).get(generateurAleatoire.next(16) % 299);
    }


    public void ajouterIndividu(Individu individu, int x, int y) {
        grille.get(x).get(y).addNewIndividu(individu);
    }


    public static Grille creerGrille(int lignes, int colonnes) {
        Grille grille = new Grille(lignes, colonnes);




        return grille;
    }
}