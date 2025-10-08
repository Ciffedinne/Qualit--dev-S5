package r5a08_findmyword_tp3.r5a08_findmyword;

import org.junit.jupiter.api.Test;
import r5a08_findmyword.Letter;
import r5a08_findmyword.Score;
import r5a08_findmyword.Word;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WordTest {

    @Test
    void should_check_one_incorrect_letter() {
        r5a08_findmyword.Word word = new r5a08_findmyword.Word("Ciff");
        r5a08_findmyword.Score actual = word.guess("j");
        assertNotNull(actual);
        assertEquals(r5a08_findmyword.Letter.INCORRECT, actual.letter(0));
    }

    @Test
    void should_check_one_correct_letter() {
        r5a08_findmyword.Word word = new Word("ciff");
        Score actual = word.guess("ciff");
        assertNotNull(actual);
        assertEquals(Letter.CORRECT, actual.letter(0));
    }
}
