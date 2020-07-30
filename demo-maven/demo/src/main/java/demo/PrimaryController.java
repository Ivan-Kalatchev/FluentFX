package demo;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.*;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.kordamp.ikonli.javafx.FontIcon;

import impl.fluentfx.styles.demo.CustomTreeCellSkin;

public class PrimaryController {

    @FXML
    public TextField AzNeZnam;

    @FXML
    public ImageView Ham;

    @FXML
    public Button Ham1;

    // @FXML
    // public TreeView<TreeItem<String>> NavigationView;

    @FXML
    public ListView NavigationView2;

    @FXML
    public VBox Nav;

    @FXML
    public TreeView<TreeItem<String>> Settings;

    private Boolean isOpened = false;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void WriteNE() throws IOException {
        //System.out.println(AzNeZnam.getText());
        //AzNeZnam.setText("NZZZZZZZZZZZZZ");
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

        Label a = new Label();
        a.setText("Home");
        a.setGraphic(fontAwesome.create(FontAwesome.Glyph.HOME));
        NavigationView2.getItems().add(a);

        Label files = new Label();
        files.setText("Historical wethers");
        files.setGraphic(fontAwesome.create(FontAwesome.Glyph.LINE_CHART));
        NavigationView2.getItems().add(files);

        Label user = new Label();
        user.setText("Favourites");
        user.setGraphic(fontAwesome.create(FontAwesome.Glyph.STAR_ALT));
        NavigationView2.getItems().add(user);

        // for (Object i : NavigationView2.getItems()) {
        //     ((Label)i).getParent().Text(((Label)i).getText());
        // }

        // TreeItem webItem = new TreeItem("Data");
        // webItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.TABLE));
        // rootItem.getChildren().add(webItem);

        // TreeItem aItem = new TreeItem("Camera");
        // aItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.CAMERA));

        // TreeItem javaItem = new TreeItem("Buttons");
        // javaItem.setGraphic(fontAwesome.create(FontAwesome.Glyph.CAMERA));

        // rootItem.getChildren().add(javaItem);
        // rootItem.getChildren().add(aItem);
        // System.out.println("Raboti");
        // NavigationView.setRoot(rootItem);
        // System.out.println("Raboti2");

        NavigationView2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateSelectedItem(newValue));
    }

    @FXML
    public void Collapse(){
        isOpened = !isOpened;
        if(isOpened) {
            for (Object it : NavigationView2.getItems()) {
                try{
                    System.out.println(((Label)it).getText());
                    ((Label)it).setGraphicTextGap(100);
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
            Nav.setPrefWidth(35); 
            return;
        } else {
            for (Object it : NavigationView2.getItems()) {
                try{
                    System.out.println(((Label)it).getText());
                    ((Label)it).setGraphicTextGap(5);
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
            Nav.setPrefWidth(200); return;
        }
    }

    private void updateSelectedItem(Object newValue) {      
        System.out.println(newValue);
    }
}
