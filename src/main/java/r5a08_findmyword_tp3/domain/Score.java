package r5a08_findmyword_tp3.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final String correct;
    private final List<Letter> results = new ArrayList<>();
    private int position = 0;

    public Score(String correct) {
        this.correct = correct;
    }

    public void assess(String attempt, String s) {
        for (char currentLetter : attempt.toCharArray()) {
            results.add(scoreForLetter(currentLetter));
            position++;
        }
        position = 0;
    }

    private Letter scoreForLetter(char currentLetter) {
        if (isCorrectLetter(currentLetter)) {
            return Letter.CORRECT;
        }
        if (isLetterOccursInWord(currentLetter)) {
            return Letter.PART_CORRECT;
        }
        return Letter.INCORRECT;
    }

    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }

    private boolean isLetterOccursInWord(char currentLetter) {
        return correct.contains(String.valueOf(currentLetter));
    }

    public Letter letter(int i) {
        return results.get(i);
    }
}