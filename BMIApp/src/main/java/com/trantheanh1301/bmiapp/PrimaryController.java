package com.trantheanh1301.bmiapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

//Ctrl + Spcae để nó nhắc
//@FXMKL để gán nó thành đối tượng -> giống như new A  = A(txtWeght)
public class PrimaryController {
   @FXML private TextField txtWeight;
   @FXML private TextField txtHeight; 
//   Rồi qua bên code thêm -> fx:id vào
   
 
//Xong rồi qua bên Code bên giao diện thêm vào event
//   Nó sẽ tự bắt sự kiện đầu tiên
public void TinhBMI(ActionEvent evt){
    double h = Double.parseDouble(txtWeight.getText());
    double w = Double.parseDouble(txtHeight.getText());
    double bmi = w/Math.pow(h,2);
    String res = "";
    if (bmi < 18.5){
        res = "Gầy";
    }
    else if (bmi < 25){
        res = "Bình thường";
    }
    else {
        res = "Béo phì";
    }
    

}
}
