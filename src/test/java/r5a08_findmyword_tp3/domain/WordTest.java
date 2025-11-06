package r5a08_findmyword_tp3.domain;

import org.junit.jupiter.api.Test;
import static r5a08_findmyword_tp3.domain.Letter.*;
import static org.assertj.core.api.Assertions.*;

public class WordTest {

    @Test
    void should_check_one_incorrect_letter() {
        Word word = new Word("E");
        Score score = word.guess("B");
        assertScoreForGuess(score, INCORRECT);
    }

    @Test
    void should_check_one_correct_letter() {
        Word word = new Word("E");
        Score score = word.guess("E");
        assertScoreForGuess(score, CORRECT);
    }

    @Test
    void should_check_second_letter_wrong_position() {
        Word word = new Word("EM");
        Score score = word.guess("GE");
        assertScoreForGuess(score, INCORRECT, PART_CORRECT);
    }

    @Test
    void should_check_all_score_combinations_correct() {
        Word word = new Word("EMI");
        Score score = word.guess("GET");
        assertScoreForGuess(score, INCORRECT, PART_CORRECT, INCORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores) {
        assertThat(score.size())
                .as("Le score doit contenir %d lettres", expectedScores.length)
                .isEqualTo(expectedScores.length);

        for (int position = 0; position < expectedScores.length; position++) {
            assertThat(score.letter(position))
                    .as("Position %d", position)
                    .isEqualTo(expectedScores[position]);
        }
    }
}