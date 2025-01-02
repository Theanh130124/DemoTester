/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Question;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;//Dùng cho java
import com.trantheanh1301.unittestdemo.JDBCUtils;

import com.trantheanh1301.pojo.Question;
import com.trantheanh1301.services.QuestionServices;
import java.sql.SQLException;

/**
 *
 * @author LAPTOP
 */
public class JdbcDemo {
    public static void main (String [] agrs) throws ClassNotFoundException, SQLException{
        Question qs = new Question("Đây là câu hỏi tạo bởi Tester nằm trong JdbcDemo",2);
        QuestionServices s = new QuestionServices();
        s.addQuestion(qs, null);
    }
}

//        //Jdbc tương tác được nhiều CSDL ( và phải cần nạp driver  ) còn các bước dưới giống hết .
//        
//        //B1 . Nạp driver
//                //Lên maven respontory -> lấý mysql connector
//                
////                Đã import qua bên JDBCUtils
//                
//                
//        //B2. Mở kết nối
////              Đã import qua bên JDBCUtils
//                      
//        Connection conn = JDBCUtils.getConn();
//            
//        //Có thể dùng PreparedStatement để tránh tấn công SQL injections
//                
//        //B3.Thực thi truy vấn
//        Statement stm = conn.createStatement();
//        
//          //+Truy vấn dữ liệu : select
//          //Trả ra dữ liệu là curor
//      
//          
//          //Lệnh đã được chuyển qua CategoryServices
//          
//          //-> Truy vấn dữ liệu và trả về String
//          
//          
//          
//          
//          
//          
//          //+Định nghĩa dữ liệu : insert , update , delete
////          int create = stm.executeUpdate("INSERT INTO category(name) VALUES('Prep')"); //-> Luôn trả về số nguyên
////          System.out.println(create); //Nếu đúng nó sẽ trả về só dương ( số lượng dòng của dòng mà nó tác động , nếu sai nó sẽ trả ra số âm)
//          
////          int update = stm.executeUpdate("UPDATE category SET name='Update Prep' WHERE name = 'Prep'" );
////          System.out.println(update);
//          
////          int delete = stm.executeUpdate("DELETE FROM category WHERE name ='Update Prep'");
////          System.out.println(delete);
////         
//        //B4.Đóng kết nối
//        conn.close();

    


