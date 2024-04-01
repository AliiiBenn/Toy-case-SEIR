

// TODO: Instancier les variables dE, dI et dR de façon aléatoire avec une distribution exponentielle...
// TODO: Vérifier le temps écoulé pour passer d'un état à un autre



public final class Individu {
    private Status statusActuel;

    private int dE;
    private int dI;
    private int dR;


    private Individu(Status statusActuel, int dE, int dI, int dR) {
        this.statusActuel = statusActuel;
    }

    public Status getStatusActuel() {
        return statusActuel;
    }

    public void setStatusActuel(Status statusActuel) {
        
        this.statusActuel = statusActuel;
    }

    public int getdE() {
        return dE;
    }

    public int getdI() {
        return dI;
    }

    public int getdR() {
        return dR;
    }

    public static Individu createIndividu() {
        int valeurDefautTemporaire = 1;

        return new Individu(Status.SUSCEPTIBLE, valeurDefautTemporaire, valeurDefautTemporaire, valeurDefautTemporaire);

    }
}