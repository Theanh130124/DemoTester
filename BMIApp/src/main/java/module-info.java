module com.trantheanh1301.bmiapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.trantheanh1301.bmiapp to javafx.fxml;
    exports com.trantheanh1301.bmiapp;
}
