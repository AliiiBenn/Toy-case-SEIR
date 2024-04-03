
// ? Le fonctionnement pourrait être que pour chaque individu :
// ? - Si l'individu est susceptible, on regarde s'il a des voisins infectés. Si c'est le cas, on le passe en état exposé.
// ? - Sinon, on modifie le temps d'exposition de l'individu. 
// ? - On déplace l'individu dans une liste aléatoire de la grille.


public class Simulation {
    private final int NB_LIGNES = 300;
    private final int NB_COLONNES = 300;

    private final int NB_INDIVIDUS = 20000;

    private Grille grille;
    private MTRandom generateurAleatoire;

    public Simulation() {
        grille = Grille.creerGrille(NB_LIGNES, NB_COLONNES);
        generateurAleatoire = new MTRandom();   
    }

    private void infectionInitiale(int quantite) {
        int nombreActuelInfecte = 0;

        while (nombreActuelInfecte < quantite) {
            Individus individus = grille.selectionnerListeAleatoire();

            if (individus.getIndividus().size() == 0 || individus.isSomeoneInfected()) {
                continue;
            }

            individus.getIndividus().get(0).setStatusActuel(Status.INFECTED);
            nombreActuelInfecte++;
            
        }
    }

    public int getNombreActuelInfecte() {
        int nombreActuelInfecte = 0;

        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                Individus individus = grille.getIndividus(i, j);

                for (Individu individu : individus.getIndividus()) {
                    if (individu.getStatusActuel() == Status.INFECTED) {
                        nombreActuelInfecte++;
                    }
                }
            }
        }

        return nombreActuelInfecte;
    }

    private void initialiserIndividus() {
        final int bits = 16;

        for (int i = 0; i < NB_INDIVIDUS; i++) {
            Individu individu = Individu.createIndividu();

            grille.ajouterIndividu(individu,
                        generateurAleatoire.next(bits) % NB_LIGNES,
                        generateurAleatoire.next(bits) % NB_COLONNES
            );
        }
    }

    public void run() {
        initialiserIndividus();
        infectionInitiale(20);

        Boolean continuer = true;

        while (continuer) {
            
        }

    }



}
