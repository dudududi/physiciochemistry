package edu.agh.physiciochemistry;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {

    private final static String APP_TITLE = "Physiciochemistry App";

    private Stage primaryStage;
    private WebEngine webEngine;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Starting application...");

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(APP_TITLE);

        initRootLayout(MainApp.class.getClassLoader().getResource("layout/MainAppLayout.fxml"));
        initWebView(MainApp.class.getClassLoader().getResource("web/index.html"));
    }

    private void initRootLayout(URL url){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            AnchorPane rootLayout = fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            WebView webView = (WebView) rootLayout.getChildren().get(0);
            webEngine = webView.getEngine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initWebView(URL url){
        if (url == null){
            throw new RuntimeException("Cannot find index.html");
        }

        Worker<Void> worker = webEngine.getLoadWorker();
        worker.stateProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                JSObject jsObject = (JSObject) webEngine.executeScript("window");
                jsObject.setMember(JavaAPI.JS_NAME, new JavaAPI());
                System.out.println("Engine initialized successfully.");
            }
        }));

        webEngine.setJavaScriptEnabled(true);
        webEngine.load(url.toExternalForm());
        System.out.println("Initializing engine...");

    }
}
