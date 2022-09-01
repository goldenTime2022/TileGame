package sample;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
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
