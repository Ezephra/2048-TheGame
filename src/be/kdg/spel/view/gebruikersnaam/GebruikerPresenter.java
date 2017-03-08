package be.kdg.spel.view.gebruikersnaam;

import be.kdg.spel.model.Gebruikernaam;
import be.kdg.spel.model.Spel;
import be.kdg.spel.view.spel.SpelPresenter;
import be.kdg.spel.view.spel.SpelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by boyan on 8/03/2017.
 */
public class GebruikerPresenter {
    private GebruikerView view;
    private Gebruikernaam model;


    public GebruikerPresenter(GebruikerView view) {
        this.view = view;
        addEventHandelers();
        updateView();
    }

    public void addEventHandelers() {
        view.getBtnVolgende().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelView spelView = new SpelView();
                Spel spel = new Spel();
                SpelPresenter spelPresenter = new SpelPresenter(spel, spelView);
                view.getScene().setRoot(spelView);

            }
        });
    }

    public void updateView() {

    }
}
