package be.kdg.spel.view.highscore;

import be.kdg.spel.model.HighscoreModel;
import be.kdg.spel.view.start.StartPresenter;
import be.kdg.spel.view.start.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by boyan on 8/02/2017.
 */
public class HighscorePresenter {
    private HighscoreModel model;
    private HighscoreView view;

    public HighscorePresenter(HighscoreModel model, HighscoreView view) {
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBtnTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView startView = new StartView();
                StartPresenter startPresenter = new StartPresenter(startView);
                view.getScene().setRoot(startView);
            }
        });
    }


    // TODO: Vul de view met de highscores uit het tekstbestand
    private void updateView() {
        model.getHighscore();
    }
}
