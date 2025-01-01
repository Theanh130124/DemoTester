module com.trantheanh1301.unittestdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; //    Phải khai báo này 


    opens com.trantheanh1301.unittestdemo to javafx.fxml;
    exports com.trantheanh1301.unittestdemo;
// Nhớ khi tạo package mới thì exports thêm services mới vào 
    exports com.trantheanh1301.services; //Viết các app để tester test
    exports com.trantheanh1301.pojo; // Lớp đại diện cho database
    
  
}
