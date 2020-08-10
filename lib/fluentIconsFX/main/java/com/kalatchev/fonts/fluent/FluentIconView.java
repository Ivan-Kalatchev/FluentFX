package com.kalatchev.fonts.fluent;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;

import java.util.concurrent.Callable;

/**
 * @author Benjamin P. Jung
 */
public class FontAwesomeIconView extends Label {

    private final ObjectProperty<FontAwesomeIcon> icon = new SimpleObjectProperty<>();

    public FontAwesomeIconView() {
        super();
        this.getStyleClass().add("FluentIconView");
        this.getStylesheets().add("com/kalatchev/fonts/fluent/FluentIconView.css");
        this.textProperty().bind(Bindings.createStringBinding(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final FontAwesomeIcon icon = FontAwesomeIconView.this.getIcon();
                return String.valueOf(icon == null ? null : icon.getUnicode());
            }
        }, this.iconProperty()));
    }


    public FontAwesomeIconView(final char unicode) {
        this();
        setText(String.valueOf(unicode));
    }

    public void setIcon(final FontAwesomeIcon icon) {
        this.icon.set(icon);
    }

    public FontAwesomeIcon getIcon() {
        return this.icon.get();
    }

    public ObjectProperty<FontAwesomeIcon> iconProperty() {
        return this.icon;
    }

}
