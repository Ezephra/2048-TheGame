package be.kdg.spel.view.spel;


import be.kdg.spel.model.Spel;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Boyan & Elias on 8/02/2017.
 */
public class SpelView extends BorderPane {
    private static final double TILE_HEIGHT = 90.0;
    private static final double TILE_WIDTH = 90.0;
    private static final double GRID_WIDTH = 410.0;
    private static final double GRID_HEIGHT = 410.0;

    GridPane valueLabels = new GridPane();

    private Label lblHuidigeScore;
    private Label lblBesteScore;
    private Label lblHuidigeScoreGetal;
    private Label lblBesteScoreGetal;
    private Label lblGebruiker;

    private Button btnRestart;
    private Button btnHighscore;

    private MenuItem miLoad;
    private MenuItem miExit;


    private Label[][] lblTileValue;
    private GridPane grid;
    private StackPane[][] stack;

    public SpelView() {
        initialiseNodes();
        layoutNodes();
    }


    private void initialiseNodes() {
        lblBesteScore = new Label("Beste score:");
        lblBesteScore.setPadding(new Insets(0, 0, 0, 90));
        lblHuidigeScore = new Label("Huidige score:");
        lblHuidigeScore.setPadding(new Insets(0, 0, 0, 30));
        lblBesteScoreGetal = new Label("0");
        lblHuidigeScoreGetal = new Label("0");
        lblHuidigeScore.setPadding(new Insets(0, 0, 0, 30));

        lblGebruiker = new Label("lol");

        lblTileValue = new Label[4][4];

        Image imageRestart = new Image("images/restart.png");
        btnRestart = new Button();
        btnRestart.setGraphic(new ImageView(imageRestart));
        btnRestart.setBackground(null);

        Image imageHigh = new Image("images/highscore.png");
        btnHighscore = new Button();
        btnHighscore.setGraphic(new ImageView(imageHigh));
        btnHighscore.setBackground(null);

        grid = new GridPane();
        stack = new StackPane[4][4];

        miExit = new MenuItem("Exit");
        miLoad = new MenuItem("Load");
    }

    private void layoutNodes() {

        HBox hBoxLabels = new HBox(10, lblHuidigeScore, lblHuidigeScoreGetal, lblGebruiker, lblBesteScore, lblBesteScoreGetal);

        HBox hBoxBtn = new HBox(5, btnHighscore, btnRestart);
        hBoxBtn.setPadding(new Insets(0, 0, 0, 210));

        VBox vBoxLabelGrid = new VBox(10, hBoxLabels, grid);
        vBoxLabelGrid.setPadding(new Insets(5, 0, 0, 100));

        Menu menuGame = new Menu("Game", null, miLoad, miExit);
        MenuBar menuBar = new MenuBar(menuGame);

        this.setTop(menuBar);
        this.setCenter(vBoxLabelGrid);
        this.setBottom(hBoxBtn);

        this.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), new CornerRadii(0), new Insets(0))));

        btnRestart.setFocusTraversable(false);
        btnHighscore.setFocusTraversable(false);

        this.setPadding(new Insets(0, 0, 20, 0));

        grid.setPrefWidth(GRID_WIDTH);
        grid.setMaxWidth(GRID_WIDTH);

        grid.setPrefHeight(GRID_HEIGHT);
        grid.setMaxHeight(GRID_HEIGHT);

        grid.setHgap(10);
        grid.setVgap(10);

        grid.setBackground(new Background(new BackgroundFill(Color.rgb(187, 173, 160), new CornerRadii(15.0), new Insets(0))));
        grid.setPadding(new Insets(10));

        DropShadow shadow = new DropShadow();
        //voegt de shadow erbij wanneer je op de knop bent
        this.btnHighscore.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btnHighscore.setEffect(shadow);
                    }
                });
        this.btnHighscore.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btnHighscore.setEffect(null);
                    }
                });

        valueLabels.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        displayGrid();


    }

    private void displayGrid() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                stack[x][y] = new StackPane();
                stack[x][y].setMinHeight(TILE_HEIGHT);
                stack[x][y].setMinWidth(TILE_WIDTH);
                stack[x][y].setBackground(new Background(new BackgroundFill(Color.rgb(238, 228, 218), new CornerRadii(10), new Insets(0))));
                lblTileValue[x][y] = new Label();
                stack[x][y].getChildren().add(lblTileValue[x][y]);
                grid.add(stack[x][y], x, y);
            }
        }
    }

    private Rectangle createTile() {
        Rectangle tile = new Rectangle(TILE_WIDTH, TILE_HEIGHT);
        tile.setFill(Color.rgb(238, 228, 218));

        tile.setArcWidth(15.0);
        tile.setArcHeight(15.0);
        return tile;
    }

    GridPane getGrid() {
        return grid;
    }

    public StackPane getStack(int x, int y) {
        return stack[x][y];
    }

    Label getTileValue(int x, int y) {
        return lblTileValue[x][y];
    }

    public Label getLblHuidigeScoreGetal() {
        return lblHuidigeScoreGetal;
    }

    public Paint getbackgroundtile(int value) {
        switch (value) {
            case 2:
                return Color.rgb(238, 228, 218);
            case 4:
                return Color.rgb(237, 224, 200);
            case 8:
                return Color.rgb(242, 177, 121);
            case 16:
                return Color.rgb(245, 149, 99);
            case 32:
                return Color.rgb(246, 124, 95);
            case 64:
                return Color.rgb(246, 94, 59);
            case 128:
                return Color.rgb(237, 207, 114);
            case 256:
                return Color.rgb(237, 204, 97);
            case 512:
                return Color.rgb(237, 200, 80);
            case 1024:
                return Color.rgb(237, 197, 63);
            case 2048:
                return Color.rgb(237, 194, 46);
        }
        return Color.rgb(205, 193, 180);
    }

    public Button getBtnRestart() {
        return btnRestart;
    }


    public Button getBtnHighscore() {
        return btnHighscore;
    }

    public Label getLblGebruiker() {
        return lblGebruiker;
    }

    public void setLblGebruiker(Label lblGebruiker) {
        this.lblGebruiker = lblGebruiker;
    }

    public MenuItem getMiLoad() {
        return miLoad;
    }

    public MenuItem getMiExit() {
        return miExit;
    }

    public Label getLblBesteScoreGetal() {
        return lblBesteScoreGetal;
    }
}
