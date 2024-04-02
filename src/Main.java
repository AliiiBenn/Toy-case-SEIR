import java.util.ArrayList;

public class Main {
    Grille grille;
    MTRandom generateurAleatoire;

    public static void main(String[] args) {

        final int nbLignes = 2;
        final int nbColonnes = 2;

        Grille grille = Grille.creerGrille(nbLignes, nbColonnes);
        MTRandom generateurAleatoire = new MTRandom();
  
        final int nbIndividus = 1;

        // System.out.println(grille.getGrille());

        for (int i = 0; i < nbIndividus; i++) {
            Individu individu = Individu.createIndividu();


            grille.ajouterIndividu(individu, generateurAleatoire.next(16) % nbLignes, generateurAleatoire.next(16) % nbColonnes);
        }

        
        ArrayList<ArrayList<Individus>> grilleTemporaire = grille.getGrille();

        int x = 0;
        int y = 0;


        for (ArrayList<Individus> ligne : grilleTemporaire) {
            for (Individus individus : ligne) {
                System.out.println(individus.getIndividus());

                if (individus.getIndividus().size() > 0) {
                    x = grilleTemporaire.indexOf(ligne);
                    y = ligne.indexOf(individus);
                }
            }
        }

        grille.deplacerIndividu(
            grille.getIndividus(x, y).get(0),
            grille.getGrille().get(x).get(y),
            grille.getGrille().get(1).get(1)
        );
        
        System.out.println("Après déplacement");

        for (ArrayList<Individus> ligne : grilleTemporaire) {
            for (Individus individus : ligne) {
                System.out.println(individus.getIndividus());
            }
        }


    }

    public void randomInfectIndividus(int quantity) {

        for (int i = 0; i < quantity; i++) {
            int x = generateurAleatoire.next(16) % 299;
            int y = generateurAleatoire.next(16) % 299;

            Individus individus = grille.getGrille().get(x).get(y);

            if (individus.isSomeoneInfected()) {
                i--;
            } else {
                individus.getIndividus().get(generateurAleatoire.next(16) % individus.getIndividus().size()).setStatusActuel(Status.INFECTED);
            }


        }
    }

}

