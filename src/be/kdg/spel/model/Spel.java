package be.kdg.spel.model;

import javafx.scene.control.Label;

import java.util.Random;


/**
 * Created by Boyan & Elias on 8/02/2017.
 */
public class Spel extends Label{
    private int value;

    public Spel() {
        this(0);
    }

    public Spel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int randomTile(){
        Random r = new Random();
        int value = (r.nextInt(2) + 1) * 2;
        return value;
    }

}
