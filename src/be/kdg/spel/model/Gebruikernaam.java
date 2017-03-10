package be.kdg.spel.model;


import javafx.scene.control.Label;

/**
 * Created by boyan on 8/03/2017.
 */
public class Gebruikernaam {
    private String naam;
    private Label lblNaam;

    public Gebruikernaam(String naam) {
        this.naam = naam;
        this.lblNaam = new Label(naam);
    }

    public Label getNaam() {
        return lblNaam;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }
}
