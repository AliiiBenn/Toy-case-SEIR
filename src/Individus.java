import java.util.ArrayList;

public final class Individus {
    private ArrayList<Individu> individus;

    
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

}