module com.trantheanh1301.englishapp {
    requires javafx.controls;
    requires javafx.fxml;
    
    //nhớ thêm này khi mới lấy từ project khác qua
     requires java.sql; //    Phải khai báo này 

    opens com.trantheanh1301.englishapp to javafx.fxml;
    exports com.trantheanh1301.englishapp;
    exports com.trantheanh1301.services;
    exports com.trantheanh1301.pojo;
}
