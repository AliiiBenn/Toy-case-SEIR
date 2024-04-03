import java.util.ArrayList;
import java.util.Iterator;

public final class IndividusIterable implements Iterable<Individu> {
    private ArrayList<Individu> individus;

    public IndividusIterable() {
        this.individus = new ArrayList<Individu>();
    }

    public void addIndividus(Individu individu) {
        this.individus.add(individu);
    }

    public void removeIndividus(Individu individu) {
        this.individus.remove(individu);
    }

    public void removeIndividus(int index) {
        this.individus.remove(index);
    }

    public boolean isIndividus(Individu individu) {
        return this.individus.contains(individu);
    }

    public ArrayList<Individu> getIndividus() {
        return individus;
    }

    public boolean isSomeoneInfected() {
        for (Individu individu : individus) {
            if (individu.getStatusActuel() == Status.INFECTED) {
                return true;
            }
        }

        return false;
    }

    public Individu get(int index) {
        return individus.get(index);
    }

    @Override
    public Iterator<Individu> iterator() {
        return new Iterator<Individu>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < individus.size();
            }

            @Override
            public Individu next() {
                return individus.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }
}
