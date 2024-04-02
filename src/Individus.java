import java.util.ArrayList;

public final class Individus {
    private ArrayList<Individu> individus;


    public Individus() {
        individus = new ArrayList<Individu>();
    }
    
    public ArrayList<Individu> getIndividus() {
        return individus;
    }

    public void addNewIndividu(Individu individu) {
        individus.add(individu);
    }

    public void removeIndividu(Individu individu) {
        individus.remove(individu);
    }

    public void removeIndividu(int index) {
        individus.remove(index);
    }

    public Boolean isIndividu(Individu individu) {
        return individus.contains(individu);
    }

    public Boolean isSomeoneInfected() {
        for (Individu individu : individus) {
            if (individu.getStatusActuel() == Status.INFECTED) {
                return true;
            }
        }

        return false;
    }


    public static Individus createIndividus(ArrayList<Individu> individus) {
        Individus individus = new Individus();

        for (Individu individu : individus) {
            individus.addNewIndividu(individu);
        }

        return individus;
    }

}