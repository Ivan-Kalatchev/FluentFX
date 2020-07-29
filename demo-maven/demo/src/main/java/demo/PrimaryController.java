package demo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.kordamp.ikonli.javafx.FontIcon;

public class PrimaryController {

    @FXML
    public TextField AzNeZnam;

    @FXML
    public ImageView Ham;

    @FXML
    public Button Ham1;

    @FXML
    public TreeView<TreeItem<String>> NavigationView;

    @FXML
    public TreeView<TreeItem<String>> Settings;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void WriteNE() throws IOException {
        //System.out.println(AzNeZnam.getText());
        //AzNeZnam.setText("NZZZZZZZZZZZZZ");

        TreeItem rootItem = new TreeItem("Tutorials");

        GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");

        FontIcon aIcon = new FontIcon();

        Ham1.setGraphic(fontAwesome.create(FontAwesome.Glyph.BARS));

        TreeItem webItem = new TreeItem("Data");
        webItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.TABLE));
        rootItem.getChildren().add(webItem);

        TreeItem aItem = new TreeItem("Camera");
        aItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.CAMERA));

        TreeItem javaItem = new TreeItem("Buttons");
        javaItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.BUILDING));

        rootItem.getChildren().add(javaItem);
        rootItem.getChildren().add(aItem);
        System.out.println("Raboti");
        NavigationView.setRoot(rootItem);
        System.out.println("Raboti2");
    }

    @FXML
    protected void initialize() {
        TreeItem rootItem = new TreeItem("Tutorials");

        GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");

        FontIcon aIcon = new FontIcon();

        Ham1.setGraphic(fontAwesome.create(FontAwesome.Glyph.BARS));

        // TreeItem settings = new TreeItem("Settings");
        // settings.setGraphic(fontAwesome.create(FontAwesome.Glyph.GEAR));
        // Settings.setRoot(settings);

        TreeItem webItem = new TreeItem("Data");
        webItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.TABLE));
        rootItem.getChildren().add(webItem);

        TreeItem aItem = new TreeItem("Camera");
        aItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.CAMERA));

        TreeItem javaItem = new TreeItem("Buttons");
        javaItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.BUILDING));

        rootItem.getChildren().add(javaItem);
        rootItem.getChildren().add(aItem);
        System.out.println("Raboti");
        NavigationView.setRoot(rootItem);
        System.out.println("Raboti2");

        NavigationView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateSelectedItem(newValue));
    }

    private void updateSelectedItem(Object newValue) {      
        System.out.println(newValue);
    }
}
