package r5a08_findmyword_tp3.domain;

import org.junit.jupiter.api.Test;
import static r5a08_findmyword_tp3.domain.Letter.*;
import static org.assertj.core.api.Assertions.*;

public class WordTest {

    @Test
    void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word(correctWord: "E"); // Le mot à deviner fait une lettre

        // Act
        Score score = word.guess(attempt: "B");

        // Assert
        assertScoreForGuess(score, INCORRECT);
    }

    @Test
    void should_check_one_correct_letter() {
        // Arrange
        Word word = new Word(correctWord: "E"); // Le mot à deviner fait une lettre

        // Act
        Score score = word.guess(attempt: "E");

        // Assert
        assertScoreForGuess(score, CORRECT);
    }

    @Test
    void should_check_second_letter_wrong_position() {
        Word word = new Word(correctWord: "EM");
        Score score = word.guess(attempt: "GE");

        assertScoreForGuess(score, INCORRECT, PART_CORRECT);
    }

    @Test
    void should_check_all_score_combinations_correct() {
        Word word = new Word(correctWord: "EMI");
        Score score = word.guess(attempt: "GET");

        assertScoreForGuess(score, INCORRECT, PART_CORRECT, CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores) {
        for (int position = 0; position < expectedScores.length; position++) {
            Letter expected = expectedScores[position];
            assertThat(score.letter(position))
                    .isEqualTo(expected);
        }
    }
}