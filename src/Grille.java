import java.util.ArrayList;


// TODO: Avoir la possibilité de récupérer les voisins d'une liste d'individus
// TODO: Ajouter le système de déplacement d'un individu précis d'une liste. On peut stocker temporairement l'individu dans une variable temporaire puis l'affecter à une autre liste tout en le supprimant de la liste d'origine. 

// ? Le fonctionnement pourrait être que pour chaque individu :
// ? - Si l'individu est susceptible, on regarde s'il a des voisins infectés. Si c'est le cas, on le passe en état exposé.
// ? - Sinon, on modifie le temps d'exposition de l'individu. 
// ? - On déplace l'individu dans une liste aléatoire de la grille.


// TODO: Créer une méthode qui récupère les voisins d'une liste d'individus (la liste actuelle est aussi incluse)
// TODO: Créer une méthode pour vérifier si un individu parmi une liste d'individus est infecté
// TODO: Créer une méthode pour déplacer un individu d'une liste à une autre
// TODO: Créer une méthode pour selectionner une liste aléatoire de la grille


// TODO: Créer une méthode qui crée une grille d'individus vide (sans individus) avec une taille donnée
// TODO: Créer une méthode pour ajouter un individu à une liste d'individus aléatoire de la grille


public final class Grille {
    private ArrayList<ArrayList<Individus>> grille;




    private ArrayList<Individu> getVoisins(int x, int y) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private boolean isVoisinInfecte(ArrayList<Individu> voisins) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void deplacerIndividu(Individu individu, Individus individusOrigine, Individus individuseDestination) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Individus selectionnerListeAleatoire() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}