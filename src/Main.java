package sample;

import com.yun.unm.titlegame.Tile;
import javafx.application.Application;
import javafx.css.Size;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends Application {
    int[][] twoD_arr = new int[5][4];
    Canvas canvas = new Canvas (300 ,200);

    ArrayList listTile=new ArrayList();
    for(int i=0; i<4; i++){
        for(int j=0; j<5; j++){
            for(int k=0; k<3; k++) {
                Tile tile=new Tile();
                tile.setFill(Color.BLUE);

                listTile.add(tile);
            }
            twoD_arr[i][j] = listTile;
        }
    }



    private Stage stage;
    private Scene scene;
    @Override
    public void start(Stage primaryStage){
        this.stage=primaryStage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400,300, Color.RED);
        scene.setCursor(Cursor.CROSSHAIR);
        this.stage.setScene(scene);
        this.stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
