package be.kdg.spel.view.spel;

import be.kdg.spel.model.Richting;
import be.kdg.spel.model.Spel;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.util.Random;

/**
 * Created by Boyan & Elias on 8/02/2017.
 */
public class SpelPresenter {
    private Spel model;
    private SpelView view;
    private Random random;
    private Label[][] tileValue = new Label[4][4];
    private Richting richting;

    private int x;
    private int y;
    private int xRandom;
    private int yRandom;


    public SpelPresenter(Spel model, SpelView view) {
        this.model = model;
        this.view = view;
        addEventHandelers();
        updateView();
    }
    private void addEventHandelers() {
        view.getGrid().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case KP_UP:
                        //moveTiles(Richting.BOVEN);
                        break;
                    case KP_DOWN:
                        //moveTiles(Richting.BENEDEN);
                        break;
                    case KP_LEFT:
                        //moveTiles(Richting.LINKS);
                        break;
                    case KP_RIGHT:
                        //moveTiles(Richting.RECHTS);
                        break;
                }
            }
        });

    }

    private void updateView() {
        addRandomTile();
        addRandomTile();
        System.out.println(model.randomTile());
    }

    private void addRandomTile(){
        this.random = new Random();
        xRandom = random.nextInt(4);
        yRandom = random.nextInt(4);
        while (view.getTileValue(xRandom,yRandom).getText().equals("")){
            view.getTileValue(xRandom,yRandom).setText(Integer.toString(model.randomTile()));
            break;
        }
    }

    private Boolean checkOutOfBounds(Richting r, int x, int y){
        if (r == richting.BOVEN){
            return x < 0;
        }
        else if (r == richting.BENEDEN){
            return x > 3;
        }
        else  if (r == richting.LINKS){
            return y < 0;
        }
        else if (r == richting.RECHTS){
            return y > 3;
        }
        return false;
    }

    // TODO: moveTiles methode...
    // Nog te aanvullen



    // TODO: mergeTiles methode...
    // Nog te aanvullen


}
