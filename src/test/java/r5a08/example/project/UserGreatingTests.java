package r5a08.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class UserGreatingTests {
    @Test
    public void when_short_name_provided_should_return_correct_greeting() {
        String expected = "Bonjour,B";
        String expected_deux = "Bonjour, tata";

        UserGreating userGreeting = new UserGreating();

        String actual = userGreeting.formatGreeting("B");
        String actual_deux = userGreeting.formatGreeting(" tata");



        // Vérification du résultat

        assertEquals(expected_deux, actual_deux, "Le message de bienvenue correspond.");


    }

}
