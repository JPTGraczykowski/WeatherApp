module com.jpg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jpg to javafx.fxml;
    exports com.jpg;
}