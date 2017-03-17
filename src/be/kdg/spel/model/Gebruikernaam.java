package be.kdg.spel.model;


import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by boyan on 8/03/2017.
 */
public class Gebruikernaam {
    private String naam;
    private static final String SAVEDIR = "src/be/kdg/spel/files/";
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void onthoudNaam() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter(SAVEDIR + "players.txt"))))) {
            pw.write(naam);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
