package r5a08_findmyword_tp3.domain;

public class Word {
    private final String word;

    public Word(String correctWord) {
        this.word = correctWord;
    }

    public Score guess(String attempt) {
        Score score;
        score = new Score(word);

        score.assess(String.valueOf(0), attempt);

        return score;
    }
}