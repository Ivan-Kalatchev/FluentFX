package demo.fluentIconsFX.main.java.com.kalatchev.fonts.fluent;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

import java.util.concurrent.Callable;

/**
 * @author Benjamin P. Jung
 */
public class FluentIconView extends Label {

    private final ObjectProperty<FluentIcon> icon = new SimpleObjectProperty<>();

    public FluentIconView() {
        super();
        this.getStyleClass().add("FluentIconView");
        this.getStylesheets().add("com/kalatchev/fonts/fluent/FluentIconView.css");
        this.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final FluentIcon icon = FluentIconView.this.getIcon();
                return String.valueOf(icon == null ? null : icon.getUnicode());
            }
        }, this.iconProperty()));
    }


    public FluentIconView(final char unicode) {
        this();
        setText(String.valueOf(unicode));
    }

    public void setIcon(final FluentIcon icon) {
        this.icon.set(icon);
    }

    public FluentIcon getIcon() {
        return this.icon.get();
    }

    public ObjectProperty<FluentIcon> iconProperty() {
        return this.icon;
    }

}
