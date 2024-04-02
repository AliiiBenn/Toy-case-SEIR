

public class GenerateurAleatoire {
    public static float exponentialNegation(float lambda) {
        return (float) (-Math.log(1 - Math.random()) / lambda);
    }
}
