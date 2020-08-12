package demo.Components.ContentButton;

import java.io.IOException;

import demo.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class ContentButton extends Button {

    public Label label = new Label();
    public Label text = new Label();

    public ContentButton() {
        super();
        VBox sp = new VBox();
        
        label.setText("Standart");
        label.setFont(new Font("Segoe UI", 20));
        sp.getChildren().add(label);
        
        text.setText("This is detail text");
        sp.getChildren().add(text);
        text.setFont(new Font("Segoe UI", 13));
        text.setTextFill(Paint.valueOf("#808080"));
        sp.setAlignment(Pos.CENTER_LEFT);
        super.setPadding(new Insets(0,0,0,10));
        super.setGraphic(sp);
        // Button cb = new Button();
        // cb.setText("a");
    }


    
}