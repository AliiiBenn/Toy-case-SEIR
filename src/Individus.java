import java.util.ArrayList;

public class Individus {
    private ArrayList<Individu> individus;
    private int size;
    
    
    public ArrayList<Individu> getIndividus() {
        return individus;
    }

    public int getSize() {
        return size;
    }

    public void incrementSize() {
        size++;
    }

    public void addIndividu(Individu individu) {
        individus.add(individu);
    }

    public Individu getIndividu(int index) {
        return individus.get(index);
    }
}
