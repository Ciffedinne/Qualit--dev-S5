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

    public void assess(String attempt) {
        results.clear();
        position = 0;
        for (char currentLetter : attempt.toCharArray()) {
            results.add(scoreForLetter(currentLetter));
            position++;
        }
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
        return position < correct.length() && correct.charAt(position) == currentLetter;
    }

    private boolean isLetterOccursInWord(char currentLetter) {
        return correct.indexOf(currentLetter) != -1;
    }

    public Letter letter(int i) {
        return results.get(i);
    }

    public int size() {
        return results.size();
    }
}