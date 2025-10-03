package r5a08_findmyword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    void should_check_one_incorrect_letter() {
        Word word = new Word("E");
        Score actual = word.guess("B");
        assertNotNull(actual);
        assertEquals(Letter.INCORRECT, actual.letter(0));
    }

    @Test
    void should_check_one_correct_letter() {
        Word word = new Word("E");
        Score actual = word.guess("E");
        assertNotNull(actual);
        assertEquals(Letter.CORRECT, actual.letter(0));
    }
}
