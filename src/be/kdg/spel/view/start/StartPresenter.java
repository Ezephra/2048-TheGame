package be.kdg.spel.view.start;

import be.kdg.spel.model.Spel;
import be.kdg.spel.model.Start;
import be.kdg.spel.view.spel.SpelPresenter;
import be.kdg.spel.view.spel.SpelView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by boyan on 7/02/2017.
 */
public class StartPresenter {
    private StartView view;
    private Start model;

    public StartPresenter(StartView view) {
        this.view = view;
        addEventHandlers();
        updateView();
        addWindowEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Alert benJeZeker = new Alert(Alert.AlertType.CONFIRMATION);
                benJeZeker.setHeaderText("Je bent toch zeker?");
                Optional<ButtonType> keuze = benJeZeker.showAndWait();
                if (keuze.get().getText().equalsIgnoreCase("CANCEL")) {
                    event.consume();
                } else if (keuze.get().getText().equalsIgnoreCase("OK")) {
                    Platform.exit();
                }
            }
        });

        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelView spelView = new SpelView();
                Spel model = new Spel();
                SpelPresenter spelPresenter =
                        new SpelPresenter(model, spelView);
                view.getScene().setRoot(spelView);

                spelView.getScene().getWindow().sizeToScene();
            }
        });


    }
    private void updateView() {

    }
    public void addWindowEventHandlers () {

    }




}
