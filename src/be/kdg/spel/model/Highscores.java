package be.kdg.spel.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by boyan on 13/03/2017.
 */
public class Highscores {
    public final static int AANTAL_HIGHSCORES = 10;
    private String[] naam = new String[10];
    private String[] scores = new String[10];

    public void inlezenHighscore() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/highscores.txt")));
            String lijn = br.readLine();
            int i = 0;

            //naam streepje punten elke lijn
            while (lijn != null) {
                String[] gegeven = lijn.split("-");
                naam[i] = gegeven[0];
                scores[i] = gegeven[1];
                i++;
                lijn = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNaam(int i) {
        return naam[i];
    }

    public String getScores(int i) {
        return scores[i];
    }
}
