package demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import demo.Components.ContentButton.ContentButton;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        // ContentButton customControl = new ContentButton();
        // Button b = new Button();
        // customControl.label.setText("Hello World!");
        // customControl.getStyleClass().add("button");
        // customControl.setPrefHeight(50);
        // customControl.setPrefWidth(90);
        // Pane content = new Pane();
        // content.getStylesheets().add(App.class.getResource("NewThemeCssFluent.css").toString());
        // content.getChildren().add(customControl);
        // Scene scene1 = new Scene(content);
        // scene1.getStylesheets().add(App.class.getResource("NewThemeCssFluent.css").toString());
        // stage.setScene(scene1);
        // stage.setTitle("Custom Control");
        // stage.setWidth(300);
        // stage.setHeight(200);
        // stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}