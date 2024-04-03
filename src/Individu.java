

// TODO: Instancier les variables dE, dI et dR de façon aléatoire avec une distribution exponentielle...
// TODO: Vérifier le temps écoulé pour passer d'un état à un autre



public final class Individu {
    private Status statusActuel;

    private int dE;
    private int dI;
    private int dR;

    private int joursStatusActuel = 0;


    private Individu(Status statusActuel) {
        this.statusActuel = statusActuel;

        this.dE = (int) GenerateurAleatoire.exponentialNegation(3);
        this.dI = (int) GenerateurAleatoire.exponentialNegation(7);
        this.dR = (int) GenerateurAleatoire.exponentialNegation(365);
    }

    public Status getStatusActuel() {
        return statusActuel;
    }

    public void setStatusActuel(Status statusActuel) {
        this.statusActuel = statusActuel;
    }

    public int getJoursStatusActuel() {
        return joursStatusActuel;
    }

    private void increaseJoursStatusActuel() {
        joursStatusActuel++;
    }

    private void resetJoursStatusActuel() {
        joursStatusActuel = 0;
    }

    private Boolean isDelaiStatusDepasse() {
        switch (statusActuel) {
            case EXPOSED:
                return joursStatusActuel >= dE;
            case INFECTED:
                return joursStatusActuel >= dI;
            case RECOVERED:
                return joursStatusActuel >= dR;
            default:
                return false;
        }
    }

    private void statusSuivant() {
        switch (statusActuel) {
            case SUSCEPTIBLE:
                statusActuel = Status.EXPOSED;
                break;
            case EXPOSED:
                statusActuel = Status.INFECTED;
                break;
            case INFECTED:
                statusActuel = Status.RECOVERED;
                break;
            case RECOVERED:
                statusActuel = Status.SUSCEPTIBLE;
                break;
        }
    }

    public void changerStatusAvecDelai() {
        if (isDelaiStatusDepasse()) {
            statusSuivant();
            resetJoursStatusActuel();
        } else {
            increaseJoursStatusActuel();
        }
    }

    public static Individu createIndividu() {
        return new Individu(Status.SUSCEPTIBLE);
    }
}