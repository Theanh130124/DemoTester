
import com.trantheanh1301.services.NguyenToServices;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAPTOP
 */
public class TheAnhTester {
//    Một test case 
    @BeforeAll //annotation luôn chạy trước tất cả các test case
    public static void beforeAll(){
        System.out.println("In ra đầu tiên");
    }
    @AfterAll //annotation luôn chạy sau tất cả các test case
    public static void affterAll(){ //là static là vì 2 thằng này dùng chung và chỉ chạy 1 lần -> test khác không chạy lại
        System.out.println("In ra sau cùng");
    }
    
    @BeforeEach
    public void beforeEach(){
        System.out.println("Luôn chạy trước mọi @Test cứ mỗi 1 test là chạy lại nó");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("Luôn sau mọi @Test cứ mỗi 1 test là chạy lại nó");
    }
    //        Mong muốn true
    
    @Test //annotation để đánh dấu phương thức là một test case
    @DisplayName("Kiểm tra số nguyên tố chẳn")
    @Tag("critical")
    public void testEvenNumber()
    {
        int n =2 ;
        boolean expected = true; //giá trị kì vọng
        boolean actual = NguyenToServices.isNguyenTo(n); //giá trị thực sự
//        Assertion -> kiểm tra đầu ra mong muốn
        Assertions.assertEquals(expected,actual , "Cài thuật toán sai (chỉ hiện khi error) !!! (Dòng này thêm vào để nhìn bên Test Results");

    }
    //    Mong muốn false
    @Test 
    @DisplayName("Kiểm tra số nguyên tố chẳn")
    @Tag("critical")
    public void testEvenNumber2()
    {
        int n = 4 ;
        boolean actual = NguyenToServices.isNguyenTo(n); 
        Assertions.assertFalse(actual,"Cài thuật toán sai (chỉ hiện khi error) !!! (Dòng này thêm vào để nhìn bên Test Results");
        
    }
   //        Mong muốn true
    @Test
    @DisplayName("Kiểm tra số nguyên tố lẻ")
    public void testOddNumber(){
        int n =5 ;
        boolean actual = NguyenToServices.isNguyenTo(n); 
        Assertions.assertTrue(actual,"Cài thuật toán sai (chỉ hiện khi error) !!! (Dòng này thêm vào để nhìn bên Test Results");
    }
    @Test
    public void testException(){
        Assertions.assertThrows(ArithmeticException.class, ()-> {
                NguyenToServices.isNguyenTo(-5);
        });
        //Truyền vào ngoại lệ mong muốn ktra
    }
    //Test đo thời gian 
@Test
public void testTimeOut(){
    Assertions.assertTimeout(Duration.ofSeconds(1), () -> {   //duration.ofSeconds để lựa chọn đơn vị thời gian tối đa là   là 1 s 
        NguyenToServices.isNguyenTo(113);
    });
}






}



//Test File để chạy hoặc Ctrl +F6  -> hoặc có thể chạy từng test case


//Nhớ xem Test Results để biết các testcase đã đúng hay chưa 