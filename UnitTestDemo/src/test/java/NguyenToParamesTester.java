/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAPTOP
 */

import com.trantheanh1301.services.NguyenToServices;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;


public class NguyenToParamesTester {
    
    
    //Việc chỉ có tham số test thay đổi thôi -> Thì ta có thể Dùng Parameteried test để gom nhóm lại

//Junit 5 Params
    @ParameterizedTest
    @ValueSource(ints = {}) //này truyền vào danh sách số muốn test
    public void testOddNumber(int n){  //m để hứng từng thằng truyền vào
        boolean actual = NguyenToServices.isNguyenTo(n);
        Assertions.assertTrue(actual);
        
    }
    @ParameterizedTest
    @CsvSource(value = {"2,false","11,true","1,false"}) //các cột cách nhau bằng dấu phảy hoặc cách
    public void testCSV(int n , boolean expected){ //  n sẽ hứng số 
        boolean actual = NguyenToServices.isNguyenTo(n);
        Assertions.assertEquals(actual, expected);  // nghĩa là so sánh 2 mình tự cho là false so với thực tế có đúng là ssoo nguyên tố không
        
    }
    
//    Phải dùng này vì đã tách datatest ra quên Other Test Source
    @ParameterizedTest //numLibesToKip dòng bỏ qua -> bỏ dòng đầu vì mk định nghĩa tiêu đề
    @CsvFileSource(resources="/data/data.csv" ,numLinesToSkip = 1) //không có resoucres vẫn được nhưng phải truyền đg dẫn tuyệt đối , có nó nó tự vào tới src/main/resources , 
    public void testCSVChuan(int n , boolean expected){
        boolean actual = NguyenToServices.isNguyenTo(n);
        Assertions.assertEquals(actual, expected);
        
    }
    @ParameterizedTest
    @MethodSource(value = "ntData")
    public void testMethod(int n , boolean expected){
        boolean actual = NguyenToServices.isNguyenTo(n);
        Assertions.assertEquals(actual,expected);
        
    }
    
    //Cách thứ 4 này hay dùng -> Có truy vấn dữ liệu 
    static Stream<Arguments> ntData(){
        //...
        return Stream.of(
                //Arguments sẽ tương úng với 1 phần tử trong Stream
                Arguments.arguments(3,true),
                Arguments.arguments(4,false)
                );
        
        
    }
    
    
}
//Nên tách datatest ra ngoài luôn cụ thể là tách  @CsvSource(value = {"2,false","11,true","1,false"})  và   @ValueSource(ints = {})
//Bằng cách tạo một resources trong test bên Files