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

        //Create a new VBox
        VBox sp = new VBox();
        
        //Set the default label
        label.setText("Standart");

        //Label options
        label.setFont(new Font("Segoe UI", 20));
        
        //Set default text
        text.setText("This is detail text");

        //Set text options
        text.setFont(new Font("Segoe UI", 13));
        text.setTextFill(Paint.valueOf("#808080"));

        //Add text and label to the VBox
        sp.getChildren().add(text);

        //Set the vbox aligment
        sp.setAlignment(Pos.CENTER_LEFT);
        sp.getChildren().add(label);

        //Button padding
        super.setPadding(new Insets(0,0,0,10));

        //Graphic
        super.setGraphic(sp);
    }


    
}