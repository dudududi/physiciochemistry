package edu.agh.physiciochemistry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private final static String APP_TITLE = "Physiciochemistry App";

    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_TITLE);

        initRootLayout();

    }

    private void initRootLayout(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getClassLoader().getResource("layout/MainAppLayout.fxml"));
            rootLayout = fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
