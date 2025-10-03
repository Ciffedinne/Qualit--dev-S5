package r5a08.example.project;

public class UserGreating {
    public static String formatGreeting(String nom){
        if (nom == null || nom.trim().isEmpty()) {
            throw new UserGreatingFailureException("Le nom ne doit pas être vide.");
        }
        if (nom.length()> 10){
            throw new UserGreatingFailureException("Le nom ne doit pas dépasser 10 caractères.");
        }
        if (!nom.matches("[a-zA-Z0-9]+")) {
            throw new UserGreatingFailureException("Le nom ne doit pas contenir de caractères spéciaux ni d'espaces.");
        }
        return "Bonjour," + nom;
    }
}
