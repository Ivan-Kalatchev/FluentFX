package demo.Helpers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;

public class NavigationHelper {

    public void RequestNavigation(Pane Content, String To) throws IOException {

        StringBuilder FinalScreen = new StringBuilder();
        if(To.contains(" ")){
            for (String CurrentWord : To.split(" ")) {
                String crr = CurrentWord;
                crr = crr.replaceFirst(crr.split("")[0], crr.split("")[0].toUpperCase());
                FinalScreen.append(crr);
            }
        } else {FinalScreen.append(To);}
        Content.getChildren().clear();
        Pane NewFXMLParent =  FXMLLoader.load(getClass().getResource(FinalScreen.toString() +  ".fxml"));
        Content.getChildren().add(NewFXMLParent);

    }

}