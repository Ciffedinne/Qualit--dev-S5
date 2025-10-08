package r5a08_findmyword_tp3.r5a08_findmyword;

public class Word {
    private String word;

    public Word(String correctWord) {
        this.word = correctWord;
    }

    public Score guess(String attempt) {
        Score score = new Score(word);
        for (int i = 0; i < word.length(); i++) {
            score.assess(i, attempt);
        }
        return score;
    }
}
