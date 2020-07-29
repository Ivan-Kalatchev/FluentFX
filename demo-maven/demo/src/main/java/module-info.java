module demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens demo to javafx.fxml;
    exports demo;
}