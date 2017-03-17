package be.kdg.spel.model;


import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Elias & Boyan
 */
public class Gebruikernaam {
    private String naam;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Hier word er telkens een geruikersnaam weggeschreven in de bestand player
     */

    public void onthoudNaam() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("src/be/kdg/spel/files/players.txt"))))) {
            pw.write(naam);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
