module com.trantheanh1301.unittestdemo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.trantheanh1301.unittestdemo to javafx.fxml;
    exports com.trantheanh1301.unittestdemo;
}
