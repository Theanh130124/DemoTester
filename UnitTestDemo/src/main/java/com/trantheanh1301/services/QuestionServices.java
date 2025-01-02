/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Choice;
import com.trantheanh1301.pojo.Question;
import com.trantheanh1301.unittestdemo.JDBCUtils;
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
          //Nếu quên lệnh có thể Send to SQL Editor bên Mysql
          String sql = "INSERT INTO question(id,content,category_id) VALUES(?, ? , ?)"; //Truyền vậy tranh SQL ịneections -> dấu ? sẽ là tham số truyền vào tương ứng với thứ tự Values
           PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1,q.getId()); //getId là có ở bên pojo của Question  -> kiểu gì thì lấy set đó
            stm.setString(2, q.getContent());  // Vị trí đầu là vị trí truyền vào
            stm.setInt(3, q.getCategory_id());
            
            int r = stm.executeUpdate();  //-> trả ra dòng bị ảnh hướng 
              return r > 0 ;
            
    }
   
}
   
}
