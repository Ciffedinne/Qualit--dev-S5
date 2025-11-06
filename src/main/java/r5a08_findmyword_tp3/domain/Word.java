package r5a08_findmyword_tp3.domain;

public class Word {

    private final String correctWord;
    private final Score score;

    public Word(String correctWord) {
        this.correctWord = correctWord.toUpperCase();
        this.score = new Score(this.correctWord);
    }

    public Score guess(String attempt) {
        score.assess(attempt.toUpperCase());
        return score;
    }

    public String getCorrectWord() {
        return correctWord;
    }
}