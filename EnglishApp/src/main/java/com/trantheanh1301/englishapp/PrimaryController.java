package com.trantheanh1301.englishapp;


import com.trantheanh1301.pojo.Category;
import com.trantheanh1301.pojo.Choice;
import com.trantheanh1301.pojo.Question;
import com.trantheanh1301.services.CategoryServices;
import com.trantheanh1301.services.JDBCUtils;
import com.trantheanh1301.services.QuestionServices;
import com.trantheanh1301.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{ //Sau khi đã thêm implements Init.... 

    @FXML private ComboBox<Category> cbCategory ; // gán vào bên kia -> này lấy cate từ pojo lên
    @FXML private TextField txtContent;
    @FXML private TextField txtA;
    @FXML private TextField txtB;
    @FXML private TextField txtC;
    @FXML private TextField txtD;
    @FXML private RadioButton rdoA;
    @FXML private RadioButton rdoB;
    @FXML private RadioButton rdoC;
    @FXML private RadioButton rdoD;
    @FXML private Button btnThem;
    @FXML private Button btnCapNhat;
    
    
    
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
    //Thêm sự kiện 
    public void addQuestionHandler(ActionEvent evt){
        //Lấy dữ liệu trên form truyền vào 
        //id tự tạo rồi khỏi truyền vào
        
        Question q = new Question(this.txtContent.getText() , this.cbCategory.getSelectionModel().getSelectedItem().getId());
        List<Choice> choices = new ArrayList<>();
        //Lấy nội dung , kiểm trả đc check chưa , lấy id của question
        choices.add(new Choice(this.txtA.getText(),this.rdoA.isSelected(), q.getId()));
        choices.add(new Choice(this.txtB.getText(),this.rdoB.isSelected(), q.getId()));
        choices.add(new Choice(this.txtC.getText(),this.rdoC.isSelected(), q.getId()));
        choices.add(new Choice(this.txtD.getText(),this.rdoD.isSelected(), q.getId()));
        
        QuestionServices s = new QuestionServices();
        try{
          s.addQuestion(q, choices);
          MessageBox.getBox("Question", "Thêm câu hỏi thành công", Alert.AlertType.INFORMATION).show();
                }
        catch(SQLException ex)
        {
            //Chỉnh thành ERROR
            MessageBox.getBox("Question", "Thêm câu hỏi thất bại", Alert.AlertType.ERROR).show();
           Logger.getLogger(JDBCUtils.class.getName()).log(Level.SEVERE, null, ex);
    }
        //Tạo bên utils một MessageBox hổ trợ hiển thị
    }
}

        
    


