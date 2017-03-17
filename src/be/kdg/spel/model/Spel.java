package be.kdg.spel.model;
import java.io.*;
import java.util.Random;


/**
 * Created by Boyan & Elias on 8/02/2017.
 */
public class Spel {
    private String[] scores = new String[11];
    private String[] player = new String[11];
    private int score;
    private int value;
    private String naam;
    private String best;

    public Spel() {
        this(0);
    }

    public Spel(int value) {
        this.value = value;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int randomTile() {
        Random r = new Random();
        return (r.nextInt(2) + 1) * 2;

    }


    public void naamInlezen() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/players.txt")));
            naam = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNaam() {
        return naam;
    }

    public void inlezenScores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/highscores.txt")));
            int i = 0;
            String lijn = br.readLine();
            while (lijn != null) {
                String[] gegeven = lijn.split("-");
                player[i] = gegeven[0];
                scores[i] = gegeven[1];
                lijn = br.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        best = scores[0];
    }

    public void scoreOpslaan() {
        for (int i = 10; i > 0; i--) {
            int temp = 0;
            String tempnaam = "";
            scores[10] = String.valueOf(score);
            player[10] = naam;
            if (Integer.parseInt(scores[i - 1]) < Integer.parseInt(scores[i])) {
                temp = Integer.parseInt(scores[i - 1]);
                scores[i - 1] = scores[i];
                scores[i] = String.valueOf(temp);
                tempnaam = player[i - 1];
                player[i - 1] = player[i];
                player[i] = String.valueOf(tempnaam);
            }
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/highscores.txt"))))) {
            for (int i = 0; i < 10; i++) {
                pw.write(player[i] + "-" + scores[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBest() {
        return best;
    }
}
