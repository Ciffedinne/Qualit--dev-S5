package r5a08_findmyword_tp3.r5a08_findmyword;

public class Score {
    private final String correct;
    private final Letter[] results;
    private int position;

    public Score(String correct) {
        this.correct = correct;
        this.results = new Letter[correct.length()];
        for (int i = 0; i < correct.length(); i++) {
            results[i] = Letter.INCORRECT;
        }
        this.position = 0;
    }

    public Letter letter(int i) {
        return results[i];
    }

    public void assess(int position, String attempt) {
        this.position = position;
        assertCorrectLetterAtPosition(position, attempt);
    }

    private void assertCorrectLetterAtPosition(int position, String attempt) {
        if (this.correct.charAt(position) == attempt.charAt(position)) {
            results[position] = Letter.CORRECT;
        } else {
            results[position] = Letter.INCORRECT;
        }
    }
}
