package be.kdg.spel.model;

/**
 * Created by boyan on 12/03/2017.
 */
public class HighscoreComparable implements Comparable<HighscoreComparable> {
    private int highscore;
    private String naam;

    public HighscoreComparable(int highscore, String naam) {
        this.highscore = highscore;
        this.naam = naam;
    }

    public int getHighscore() {
        return highscore;
    }

    public String getNaam() {
        return naam;
    }


    public String toString() {
        return String.format("%05d %-20s", highscore, naam);
    }

    @Override
    public int compareTo(HighscoreComparable score) {
        return score.highscore - highscore;
    }


}
