package be.kdg.spel.view.spel;

import be.kdg.spel.model.Richting;
import be.kdg.spel.model.Spel;
import javafx.event.EventHandler;
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
        view.getGrid().setFocusTraversable(true);
        view.getGrid().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode().toString());
                switch (event.getCode()) {
                    case UP:
                        moveTiles(Richting.BOVEN);
                        addRandomTile();
                        break;
                    case DOWN:
                        moveTiles(Richting.BENEDEN);
                        addRandomTile();
                        break;
                    case LEFT:
                        moveTiles(Richting.LINKS);
                        addRandomTile();
                        break;
                    case RIGHT:
                        moveTiles(Richting.RECHTS);
                        addRandomTile();
                        break;
                }
            }
        });

    }


    private void updateView() {
        addRandomTile();
        addRandomTile();

    }

    private void addRandomTile(){
        this.random = new Random();
        xRandom = random.nextInt(4);
        yRandom = random.nextInt(4);
        while (view.getTileValue(xRandom,yRandom).getText().equals("")){
            // // TODO: 5/03/2017 leeg plaats
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
    private void moveTiles(Richting r) {
        switch (r) {
            case BOVEN:
                //bij elke y kolom checked die elke vak of er plaats is.
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int checkLeeg = 0;
                        if (y == 0) {
                            continue;
                        }
                        /*if (view.getTileValue(x,y-1).getText().equals("")){
                            view.getTileValue(x,y-1).setText(view.getTileValue(x,y).getText());
                            view.getTileValue(x,y).setText("");
                        }*/
                        // als de tile leeg is
                        if (view.getTileValue(x, checkLeeg).getText().equals("")) {
                            while (view.getTileValue(x, checkLeeg).getText().equals("")) {
                                view.getTileValue(x, checkLeeg).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 3) {
                                    break;
                                }
                                checkLeeg++;
                            }
                        } else if (view.getTileValue(x, checkLeeg + 1).getText().equals("")) {
                            while (view.getTileValue(x, checkLeeg + 1).getText().equals("")) {
                                view.getTileValue(x, checkLeeg + 1).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 2) {
                                    break;
                                }
                                checkLeeg++;
                            }
                        } else {
                            while (view.getTileValue(x, checkLeeg + 2).getText().equals("")) {
                                view.getTileValue(x, checkLeeg + 2).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 1) {
                                    break;
                                }
                                checkLeeg++;
                            }
                        }
                    }
                }
                break;
            case BENEDEN:
                for (int x = 0; x < 4; x++) {
                    for (int y = 3; y >= 0; y--) {
                        int checkLeeg = 3;
                        if (y == 3) {
                            continue;
                        }
                        /*if (view.getTileValue(x,y+1).getText().equals("")){
                            view.getTileValue(x,y+1).setText(view.getTileValue(x,y).getText());
                            view.getTileValue(x,y).setText("");
                        }*/
                        if (view.getTileValue(x, checkLeeg).getText().equals("")) {
                            while (view.getTileValue(x, checkLeeg).getText().equals("")) {
                                view.getTileValue(x, checkLeeg).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 0) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        } else if (view.getTileValue(x, checkLeeg - 1).getText().equals("")) {
                            while (view.getTileValue(x, checkLeeg - 1).getText().equals("")) {
                                view.getTileValue(x, checkLeeg - 1).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 1) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        } else if (view.getTileValue(x, checkLeeg - 2).getText().equals("")) {
                            while (view.getTileValue(x, checkLeeg - 2).getText().equals("")) {
                                view.getTileValue(x, checkLeeg - 2).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 2) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        }
                    }
                }
                break;
            case LINKS:
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int checkLeeg = 0;
                        if (x == 0) {
                            continue;
                        }
                        /*if (view.getTileValue(x-1,y).getText().equals("")){
                            view.getTileValue(x-1,y).setText(view.getTileValue(x,y).getText());
                            view.getTileValue(x,y).setText("");
                        }*/
                        if (view.getTileValue(checkLeeg, y).getText().equals("")) {
                            while (view.getTileValue(checkLeeg, y).getText().equals("")) {
                                view.getTileValue(checkLeeg, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 3) {
                                    break;
                                }
                                checkLeeg++;
                            }
                        } else if (view.getTileValue(checkLeeg + 1, y).getText().equals("")) {
                            while (view.getTileValue(checkLeeg + 1, y).getText().equals("")) {
                                view.getTileValue(checkLeeg + 1, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 2) {
                                    break;
                                }
                                checkLeeg++;

                            }
                        } else {
                            while (view.getTileValue(checkLeeg + 2, y).getText().equals("")) {
                                view.getTileValue(checkLeeg + 2, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 1) {
                                    break;
                                }
                                checkLeeg++;
                            }
                        }
                    }
                }
                break;
            case RECHTS:
                for (int x = 3; x >= 0; x--) {
                    for (int y = 0; y < 4; y++) {
                        int checkLeeg = 3;
                        if (x == 3) {
                            continue;
                        }
                        /*if (view.getTileValue(x+1,y).getText().equals("")){
                            view.getTileValue(x+1,y).setText(view.getTileValue(x,y).getText());
                            view.getTileValue(x,y).setText("");
                        }*/
                        if (view.getTileValue(checkLeeg, y).getText().equals("")) {
                            while (view.getTileValue(checkLeeg, y).getText().equals("")) {
                                view.getTileValue(checkLeeg, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 0) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        } else if (view.getTileValue(checkLeeg - 1, y).getText().equals("")) {
                            while (view.getTileValue(checkLeeg - 1, y).getText().equals("")) {
                                view.getTileValue(checkLeeg - 1, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 1) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        } else {
                            while (view.getTileValue(checkLeeg - 2, y).getText().equals("")) {
                                view.getTileValue(checkLeeg - 2, y).setText(view.getTileValue(x, y).getText());
                                view.getTileValue(x, y).setText("");
                                if (checkLeeg == 2) {
                                    break;
                                }
                                checkLeeg--;
                            }
                        }
                    }
                }
                break;
        }
    }

    // TODO: mergeTiles methode...
    // Nog te aanvullen


}
