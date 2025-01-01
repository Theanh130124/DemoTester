/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;//Dùng cho java


/**
 *
 * @author LAPTOP
 */
public class JdbcDemo {
    public static void main (String [] agrs) throws ClassNotFoundException, SQLException{
        //Jdbc tương tác được nhiều CSDL ( và phải cần nạp driver  ) còn các bước dưới giống hết .
        
        //B1 . Nạp driver
                //Lên maven respontory -> lấý mysql connector
                Class.forName("com.mysql.cj.jdbc.Driver");  //Dẫn đường tới driver , thêm ngoại lệ
        //B2. Mở kết nối
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/englishdb", "root", "123456"); //Thêm ngoại lệ
            
        //Có thể dùng PreparedStatement để tránh tấn công SQL injections
                
        //B3.Thực thi truy vấn
        Statement stm = conn.createStatement();
        
          //+Truy vấn dữ liệu : select
          //Trả ra dữ liệu là curor
          
          ResultSet rs = stm.executeQuery("SELECT * FROM category");
          while (rs.next()){    //Luôn trỏ vào dòng đó
              int id = rs.getInt("id"); // có thể lấy bằng cách gọi tên cột hoặc gọi index của cột trong bảng -> index : 1 -> là cột id
              String name = rs.getString(2); // lấy ra cột name
              System.out.printf("%d-%s\n",id,name);
          }
          //-> Truy vấn dữ liệu và trả về String
          
          
          
          
          
          
          //+Định nghĩa dữ liệu : insert , update , delete
//          int create = stm.executeUpdate("INSERT INTO category(name) VALUES('Prep')"); //-> Luôn trả về số nguyên
//          System.out.println(create); //Nếu đúng nó sẽ trả về só dương ( số lượng dòng của dòng mà nó tác động , nếu sai nó sẽ trả ra số âm)
          
//          int update = stm.executeUpdate("UPDATE category SET name='Update Prep' WHERE name = 'Prep'" );
//          System.out.println(update);
          
//          int delete = stm.executeUpdate("DELETE FROM category WHERE name ='Update Prep'");
//          System.out.println(delete);
//         
        //B4.Đóng kết nối
        conn.close();
    }
    
}
