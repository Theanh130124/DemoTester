/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Choice;
import com.trantheanh1301.pojo.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author LAPTOP
 */

//Chèn câu hỏi
public class QuestionServices {
    public boolean addQuestion(Question q , List<Choice> choices) throws SQLException{
        //1 câu 4 lựa chọn
        //1 câu 1 lựa chọn đúng
    try(Connection conn = JDBCUtils.getConn()) 
        {
          conn.setAutoCommit(false); // Quan trọng : Gom toàn bộ thao tác thêm câu hỏi -> và thêm lựa chọn thành 1 -> nhất quán
          //Nó sẽ không thực hiện thao tác executeUpdate -> mà sẽ lưu ở bộ đệm 
          
          //Chỉ thực hiện lưu xuống csdl khi conn.commit(); -> vì đã set retrun true
          
          //Nếu quên lệnh có thể Send to SQL Editor bên Mysql
          String sql = "INSERT INTO question(id,content,category_id) VALUES(?, ? , ?)"; //Truyền vậy tranh SQL ịneections -> dấu ? sẽ là tham số truyền vào tương ứng với thứ tự Values
           PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1,q.getId()); //getId là có ở bên pojo của Question  -> kiểu gì thì lấy set đó
            stm.setString(2, q.getContent());  // Vị trí đầu là vị trí truyền vào
            stm.setInt(3, q.getCategory_id());
            
            int r = stm.executeUpdate();  //-> trả ra dòng bị ảnh hướng 
              
              if ( r>0){
                  //Nếu mà có update thì thực hiện gán giá trị
                  sql = "INSERT INTO choice(id,choice,is_correct,question_id) VALUES(?,?,?,?)";
                  PreparedStatement stml = conn.prepareCall(sql);
                  //Thực hiện set dữ liệu xuống csdl
                  for(Choice c: choices){
                      stml.setString(1, c.getId());
                      stml.setString(2,c.getChoice());
                      stml.setBoolean(3, c.getIs_correct());
                      stml.setString(4, c.getQuestion_id()); // này là UUID 
                      stml.execute();
                  }
              }
//              return r>0;
                try{
                    conn.commit();
                    return true;
                }catch(Exception ex){
                    ex.printStackTrace(); //in lỗi trên terminal
                    return false; // không lưu
                }
                
            
    }
   
}
   
}
