/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.trantheanh1301.pojo.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import com.trantheanh1301.services.CategoryServices; //Tạo ra mà không tháy thì phải Build lại
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;

        
public class CategoryTester {
    //Mở kết nối
    @BeforeAll
    public static void beforeAll(){
        //... Mở kết nối
    }
    //Đóng kết nối
    @AfterAll
    public static void affterAll(){
        //..Đóng kết nối
    }
    @Test
    public void testNotNull() throws SQLException{
        CategoryServices s = new CategoryServices();
        try {
            
        
        List<Category> cates = s.getCategory();
        
        //Kiểm trả có cate nào trong cates null không
        long t = cates.stream().filter(c->c.getName() == null).count();
        
        Assertions.assertTrue(t==0,"Có giá trị null trong danh sách category"); // -> mong muốn không null
        
        
        }catch(SQLException ex)
        {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE,null ,ex);
        }
        

        
    }
            @Test
        public void testUniName(){
            
             CategoryServices s = new CategoryServices();
        try {
            
        
        List<Category> cates = s.getCategory(); // lấy cate
        
        List<String> names = cates.stream().flatMap(c->Stream.of(c.getName())).collect(Collectors.toList());
        Set<String> testName = new HashSet<>(names); // Nếu name lớn hơn thằng này thì có tên trùng  -> vì thằng này là Set lọc tên tùng
        
        Assertions.assertEquals(names.size(),testName.size(),"Có tên bị trùng trong danh sách"); // -> mong muốn không null
        
        
        }catch(SQLException ex)
        {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE,null ,ex);
    }
//        Sử dụng Stream API để duyệt qua từng Category trong danh sách cates.
//Phương thức Stream.of(c.getName()) lấy ra thuộc tính name của mỗi đối tượng Category.
//collect(Collectors.toList()) chuyển tất cả các giá trị name vào một danh sách names.
//    }
//    @Test
//    public void testUniName2() {
//    CategoryServices s = new CategoryServices();
//    try {
//        List<Category> cates = s.getCategory();
//
//        Set<String> seenNames = new HashSet<>();
//        boolean hasDuplicate = cates.stream().anyMatch(c -> !seenNames.add(c.getName()));  //  anyMatch -> Kiểm tra xem có phần tử nào trong luồng !seenNames.add(c.getName()) -> nếu có tên bị thêm vào nó sẽ là false -> nếu thêm đc vào thì là true vì trong set chưa có tên đó  -> ! là true  
//
//        Assertions.assertFalse(hasDuplicate, "Có tên bị trùng trong danh sách.");
//    } catch (SQLException ex) {
//        Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//}
    
    //Set<String> seenNames = new HashSet<>();
//boolean hasDuplicate = false;
//
//for (Category c : cates) {
//    if (!seenNames.add(c.getName())) {
//        hasDuplicate = true; // Tìm thấy tên trùng
//        break;
//    }
//}
}
}
