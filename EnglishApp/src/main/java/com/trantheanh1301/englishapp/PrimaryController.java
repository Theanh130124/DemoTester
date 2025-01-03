package com.trantheanh1301.englishapp;


import com.trantheanh1301.pojo.Category;
import com.trantheanh1301.services.CategoryServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{ //Sau khi đã thêm implements Init.... 

    @FXML private ComboBox<Category> cbCategory ; // gán vào bên kia -> này lấy cate từ pojo lên

    //Thì đây là phương thức sẽ tự động nạp khi form load
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryServices s = new CategoryServices();
        try {
            List<Category> cates = s.getCategory();
            this.cbCategory.setItems(FXCollections.observableList(cates)); // ObservableList là một danh sách đặc biệt trong JavaFX. Khi có thay đổi dữ liệu (thêm, xóa, sửa), giao diện sẽ tự động cập nhật.
        } catch (SQLException ex) { //Nghĩa là xài obsservaleList -> thì khi thêm JavaFX sẽ cập nhật
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    

}
