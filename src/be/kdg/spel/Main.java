package be.kdg.spel;

import be.kdg.spel.view.start.StartPresenter;
import be.kdg.spel.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by boyan on 7/02/2017.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StartView view = new StartView();
        StartPresenter presenter = new StartPresenter(view);
        Scene scene = new Scene(view);

        primaryStage.setScene(scene);
        primaryStage.setTitle("2048");
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(600);
        primaryStage.setResizable(false);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
