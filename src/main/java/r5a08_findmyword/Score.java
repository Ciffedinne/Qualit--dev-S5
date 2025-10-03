package r5a08_findmyword;

public class Score {
    private String word;
    private Letter[] letters;

    public Score(String word) {
        this.word = word;
        this.letters = new Letter[word.length()];
    }

    public void assess(int index, String attempt) {
        char attemptLetter = attempt.charAt(index);
        char correctLetter = word.charAt(index);
        if (attemptLetter == correctLetter) {
            letters[index] = Letter.CORRECT;
        } else {
            letters[index] = Letter.INCORRECT;
        }
    }

    public Letter letter(int index) {
        return letters[index];
    }
}
