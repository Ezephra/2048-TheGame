package be.kdg.spel.view.spel;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Created by Boyan & Elias on 8/02/2017.
 */
public class SpelView extends BorderPane {
    private static final double TILE_HEIGHT = 90.0;
    private static final double TILE_WIDTH = 90.0;
    private static final double GRID_WIDTH = 410.0;
    private static final double GRID_HEIGHT = 410.0;
    private Label lblHuidigeScore;
    private Label lblBesteScore;
    private Label lblHuidigeScoreGetal;
    private Label lblBesteScoreGetal;
    private Button btnRestart;
    private Label[][] lblTileValue;
    private GridPane grid;
    private StackPane stack;

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
        btnRestart = new Button("Restart");
        lblTileValue = new Label[4][4];

        grid = new GridPane();
        stack = new StackPane();

    }

    //lol
    private void layoutNodes() {
        this.setBottom(btnRestart);
        btnRestart.setFocusTraversable(false);
        HBox hBoxLabels = new HBox(10, lblHuidigeScore, lblHuidigeScoreGetal, lblBesteScore, lblBesteScoreGetal);

        this.setTop(hBoxLabels);
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
        displayGrid();

        this.setCenter(grid);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), new CornerRadii(0), new Insets(0))));

    }

    private void displayGrid() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                stack = new StackPane();
                lblTileValue[x][y] = new Label();
                stack.getChildren().addAll(createTile(), lblTileValue[x][y]);
                grid.add(stack, x, y);
            }
        }
    }

    private Rectangle createTile(){
        Rectangle tile = new Rectangle(TILE_WIDTH,TILE_HEIGHT);
        tile.setFill(Color.rgb(238, 228, 218));
        tile.setArcWidth(15.0);
        tile.setArcHeight(15.0);
        return tile;
    }

    GridPane getGrid() {
        return grid;
    }

    public StackPane getStack() {
        return stack;
    }

    Label getTileValue(int x, int y) {
        return lblTileValue[x][y];
    }

    public Background getbackgroundtile(int value) {
        switch (value) {
            case 2:    return new Background(new BackgroundFill(Color.rgb(238,228,218),CornerRadii.EMPTY, Insets.EMPTY));
            case 4:    return new Background(new BackgroundFill(Color.rgb(237,224,200),CornerRadii.EMPTY, Insets.EMPTY));
            case 8:    return new Background(new BackgroundFill(Color.rgb(242,177,121),CornerRadii.EMPTY, Insets.EMPTY));
            case 16:   return new Background(new BackgroundFill(Color.rgb(245,149,99),CornerRadii.EMPTY, Insets.EMPTY));
            case 32:   return new Background(new BackgroundFill(Color.rgb(246,124,95),CornerRadii.EMPTY, Insets.EMPTY));
            case 64:   return new Background(new BackgroundFill(Color.rgb(246,94,59),CornerRadii.EMPTY, Insets.EMPTY));
            case 128:  return new Background(new BackgroundFill(Color.rgb(237,207,114),CornerRadii.EMPTY, Insets.EMPTY));
            case 256:  return new Background(new BackgroundFill(Color.rgb(237,204,97),CornerRadii.EMPTY, Insets.EMPTY));
            case 512:  return new Background(new BackgroundFill(Color.rgb(237,200,80),CornerRadii.EMPTY, Insets.EMPTY));
            case 1024: return new Background(new BackgroundFill(Color.rgb(237,197,63),CornerRadii.EMPTY, Insets.EMPTY));
            case 2048: return new Background(new BackgroundFill(Color.rgb(237,194,46),CornerRadii.EMPTY, Insets.EMPTY));
        }
        return new Background(new BackgroundFill(Color.rgb(205,193,180),CornerRadii.EMPTY, Insets.EMPTY));
    }

}
