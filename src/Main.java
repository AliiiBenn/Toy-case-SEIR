
public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        // simulation.run();

        // System.out.println(simulation.getNombreActuelInfecte());

        IndividusIterable individusIterable = new IndividusIterable();

        Individu individu1 = Individu.createIndividu();
        Individu individu2 = Individu.createIndividu();

        individusIterable.addIndividus(individu1);
        individusIterable.addIndividus(individu2);

        for (Individu individu : individusIterable) {
            System.out.println(individu.getStatusActuel());
        }

        individusIterable.removeIndividus(individu1);

        individusIterable.get(0).setStatusActuel(Status.INFECTED);

        

        System.out.println(individusIterable.isSomeoneInfected());
    }



}
