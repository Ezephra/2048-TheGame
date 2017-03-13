package be.kdg.spel.model;

import java.io.File;

/**
 * Created by boyan on 12/03/2017.
 */
public class HighscoreModel {
    public static final int MAXAANTAL = 10;
    static final String BESTANDSNAAM = "resources" + File.separator + "highscores.txt";
    private Highscore highscore;

    public HighscoreModel() {
        highscore = new Highscore();
        highscore.leesHighScores();
    }


}
