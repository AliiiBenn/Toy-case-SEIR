
public class Main {
    Grille grille;
    MTRandom generateurAleatoire;

    public static void main(String[] args) {

        Grille grille = Grille.creerGrille(300, 300);
        MTRandom generateurAleatoire = new MTRandom();
  
        final int nbIndividus = 20000;

        // System.out.println(grille.getGrille());

        for (int i = 0; i < nbIndividus; i++) {
            Individu individu = Individu.createIndividu();


            grille.ajouterIndividu(individu, generateurAleatoire.next(16) % 299, generateurAleatoire.next(16) % 299);
        }

        randomInfectIndividus(10);



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

