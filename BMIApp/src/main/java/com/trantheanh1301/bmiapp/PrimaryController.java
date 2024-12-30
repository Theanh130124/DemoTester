package com.trantheanh1301.bmiapp;

import com.trantheanh1301.services.BMIServices;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

//Ctrl + Spcae để nó nhắc
//@FXMKL để gán nó thành đối tượng -> giống như new A  = A(txtWeght)
public class PrimaryController {
   @FXML private TextField txtWeight;
   @FXML private TextField txtHeight; 
   @FXML private Label lblResult;
//   Rồi qua bên code thêm -> fx:id vào
   
 
//Xong rồi qua bên Code bên giao diện thêm vào event
//   Nó sẽ tự bắt sự kiện đầu tiên
public void TinhBMI(ActionEvent evt){
    double h = Double.parseDouble(txtHeight.getText());  //private nên phải get để lấy
    double w = Double.parseDouble(txtWeight.getText());
    double bmi = BMIServices.TinhBMI(h, w);
//    Chỉnh column span  2 -> thì nó chiếm 2 cột 
    String res ;
    if (bmi == 1){
        res = "Gầy";
//Text không có setTextFill Label mới có
        this.lblResult.setTextFill(Color.RED);
    }
    else if (bmi == 2){
        res = "Bình thường";
        this.lblResult.setTextFill(Color.GREEN);
    }
    else {
        res = "Béo phì";
        this.lblResult.setTextFill(Color.BLUE);
    }
    this.lblResult.setText(res); //private nên phải set để truyền vào
}
}
//Béo phì 1 , 2 ,3 .... 
