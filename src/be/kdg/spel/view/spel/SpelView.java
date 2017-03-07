package be.kdg.spel.view.spel;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;



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
    private Button btnRestart;
    private Button btnTerug;
    private Button btnHighscore;

    private Label[][] lblTileValue;
    private GridPane grid;
    private StackPane[][] stack;

    public SpelView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblBesteScore = new Label("Beste score:");
        lblBesteScore.setPadding(new Insets(0,0,0,90));
        lblHuidigeScore = new Label("Huidige score:");
        lblHuidigeScore.setPadding(new Insets(0,0,0,125));
        lblBesteScoreGetal = new Label("0");
        lblHuidigeScoreGetal = new Label("0");
        lblTileValue = new Label[4][4];

        Image imageRestart = new Image("be/kdg/spel/view/spel/images/restart.png");
        btnRestart = new Button();
        btnRestart.setGraphic(new ImageView(imageRestart));
        btnRestart.setBackground(null);

        Image imageHigh = new Image("be/kdg/spel/view/spel/images/highscore.png");
        btnHighscore = new Button();
        btnHighscore.setGraphic(new ImageView(imageHigh));
        btnHighscore.setBackground(null);

        Image imageBack = new Image("be/kdg/spel/view/spel/images/left.png");
        btnTerug = new Button();
        btnTerug.setGraphic(new ImageView(imageBack));
        btnTerug.setBackground(null);

        grid = new GridPane();
        stack = new StackPane[4][4];

    }

    //lol
    private void layoutNodes() {

        HBox hBoxLabels = new HBox(10, lblHuidigeScore, lblHuidigeScoreGetal, lblBesteScore, lblBesteScoreGetal);
        HBox hBoxBtn = new HBox(5, btnTerug, btnHighscore, btnRestart);

        this.setBottom(hBoxBtn);
        this.setTop(hBoxLabels);

        btnRestart.setFocusTraversable(false);
        btnTerug.setFocusTraversable(false);
        btnHighscore.setFocusTraversable(false);

        hBoxBtn.setPadding(new Insets(0, 0, 0, 135));

        BorderPane.setAlignment(btnRestart, Pos.BOTTOM_LEFT);
        BorderPane.setMargin(btnRestart,new Insets(0,0,0,250));

        grid.setPrefWidth(GRID_WIDTH);
        grid.setMaxWidth(GRID_WIDTH);
        grid.setPrefHeight(GRID_HEIGHT);
        grid.setMaxHeight(GRID_HEIGHT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(187, 173, 160),new CornerRadii(15.0),new Insets(0))));
        grid.setPadding(new Insets(10));
        this.setPadding(new Insets(20));

        DropShadow shadow = new DropShadow();
        //voegt de shadow erbij wanneer je op de knop bent
        this.btnTerug.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btnTerug.setEffect(shadow);
                    }
                });
        this.btnTerug.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btnTerug.setEffect(null);
                    }
                });

        valueLabels.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        displayGrid();


        this.setCenter(grid);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), new CornerRadii(0), new Insets(0))));


    }

    private void displayGrid() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                stack[x][y] = new StackPane();
                stack[x][y].setMinHeight(TILE_HEIGHT);
                stack[x][y].setMinWidth(TILE_WIDTH);
                stack[x][y].setBackground(new Background(new BackgroundFill(Color.rgb(238, 228, 218), new CornerRadii(10), new Insets(0))));
                lblTileValue[x][y] = new Label();

                /*if (!lblTileValue[x][y].getText().isEmpty()|| !lblTileValue[x][y].getText().equals("") ){
                    stack[x][y].getChildren().add(createTile(x,y));
                }*/
                stack[x][y].getChildren().addAll(createTile(x, y), lblTileValue[x][y]);

                grid.add(stack[x][y], x, y);
            }
        }
    }

    private void addTile(int x, int y) {
        if (!lblTileValue[x][y].getText().isEmpty() || !lblTileValue[x][y].getText().equals("")) {

        }
    }

    Rectangle createTile(int x, int y) {
        Rectangle tile = new Rectangle(TILE_WIDTH,TILE_HEIGHT);
        if (!lblTileValue[x][y].getText().equals("") || !lblTileValue[x][y].getText().isEmpty()) {
            tile.setFill(getbackgroundtile(Integer.parseInt(lblTileValue[x][y].getText())));
        } else {
            tile.setFill(Color.rgb(238, 228, 218));
        }
        tile.setArcWidth(15.0);
        tile.setArcHeight(15.0);
        return tile;
    }

    GridPane getGrid() {
        return grid;
    }

    StackPane getStack(int x, int y) {
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

    public Button getBtnTerug() {
        return btnTerug;
    }

    public Button getBtnHighscore() {
        return btnHighscore;
    }
}
