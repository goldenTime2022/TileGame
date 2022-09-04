package com.yun.unm.titlegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage stage) {
        //Creating the tile pane
        TilePane tilePane = new TilePane();
        StackPane stackPane = null;

        //Setting the orientation for the Tile Pane
        tilePane.setOrientation(Orientation.VERTICAL);
        //Setting the alignment for the Tile Pane
        tilePane.setTileAlignment(Pos.CENTER);
        //Setting the preferred columns for the Tile Pane
        tilePane.setPrefColumns(6); //why I setting preferred row or columns do not affect?
        // set Horizontal Gap and Vertical Gap
        tilePane.setHgap(5);
        tilePane.setVgap(5);

        for (int i = 0; i < 9; i++) {
            Tile tile =new Tile();
            tilePane.getChildren().add(tile);
        }

        Scene scene = new Scene(tilePane, 730, 730);
        stage.setTitle("stackPane inside tilePane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}