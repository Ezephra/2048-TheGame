package be.kdg.spel.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by boyan on 8/02/2017.
 */
public class Highscore {

    public final static int AANTAL_HIGHSCORES = 10;
    private List<HighscoreComparable> highscores;

    public Highscore() {
        highscores = new ArrayList<>();
    }

    public static int getAantalHighscores() {
        return AANTAL_HIGHSCORES;
    }

    public void leesHighScores() {
        try (Scanner scanner = new Scanner(new FileReader(HighscoreModel.BESTANDSNAAM))) {
            while (scanner.hasNext()) {
                int score = scanner.nextInt();
                String naam = scanner.nextLine().trim();
                highscores.add(new HighscoreComparable(score, naam));
            }
        } catch (FileNotFoundException e) {
            System.out.println(HighscoreModel.BESTANDSNAAM + " niet gevonden!");
        }
    }

    public void voegHighScoreToe(int score, String naam) {
        highscores.add(new HighscoreComparable(score, naam));
        Collections.sort(highscores);
        highscores = highscores.subList(0, HighscoreModel.MAXAANTAL); // alleen 10 eerste highscores behouden!
    }

    public void schrijfHighScores() {
        try (Formatter output = new Formatter(HighscoreModel.BESTANDSNAAM)) {
            for (int i = 0; i < HighscoreModel.MAXAANTAL; i++) {
                HighscoreComparable highscoreComparable = highscores.get(i);
                int score = highscoreComparable.getHighscore();
                String naam = highscoreComparable.getNaam();
                output.format("%05d %-20s%n", score, naam);
            }
            System.out.println("HighScores bestand opnieuw geschreven (" + HighscoreModel.BESTANDSNAAM + ")");
        } catch (FileNotFoundException e) {
            System.out.println(HighscoreModel.BESTANDSNAAM + " niet gevonden!");
        }
    }

    public List<HighscoreComparable> getHighscores() {
        return highscores;
    }
}
