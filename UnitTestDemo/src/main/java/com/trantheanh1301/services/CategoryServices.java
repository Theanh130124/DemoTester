/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Category;
import java.sql.ResultSet;
import java.util.List;
import com.trantheanh1301.unittestdemo.JDBCUtils;

/**
 *
 * @author LAPTOP
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class CategoryServices {
    public List<Category> getCategory() throws SQLException{
        List<Category> cates = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()) 
        {
          Statement stm = conn.createStatement();
          ResultSet rs = stm.executeQuery("SELECT * FROM category");
          while (rs.next()){    //Luôn trỏ vào dòng đó
              int id = rs.getInt("id"); // có thể lấy bằng cách gọi tên cột hoặc gọi index của cột trong bảng -> index : 1 -> là cột id
              String name = rs.getString(2); // lấy ra cột name
              Category c = new Category(id,name);
              cates.add(c);
              
          }
        
        }
        return cates; //Trả ra danh sách cates -> gồm các c được thêm vào
    }
}


    
// Đặt trong try để nó tự đóng
