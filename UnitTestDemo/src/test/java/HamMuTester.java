/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAPTOP
 */
import com.trantheanh1301.services.DeQuyServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class HamMuTester {
    
//    Phân vùng test
    
    //Vùng số dương mũ 0
    @Test
    public void TestMuDuong(){
        double x = 2.0;
        int n = 0; 
        double expected = 1;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
//Test case True
    }
    //Vùng số âm mũ chẳn
     @Test
    public void TestMuDuong2(){
        double x = -2.0;
        int n = 2; 
        double expected = 4.0;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số dương mũ  lẻ
     @Test
    public void TestMuDuong3(){
        double x = 2.0;
        int n = 3;
        double expected = 8.0;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số dương mũ âm 
     @Test
    public void TestMuDuong4(){
        double x = 2;
        int n = -1;
        double expected = 0.5;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số dương mũ âm lẻ
     @Test
    public void TestMuAm1(){
         double x = 2.0;
        int n = -3;
        double expected = 0.125;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số dương mũ âm chăn
     @Test
    public void TestMuAm2(){
         double x = 2.0;
        int n = -4;
        double expected = 0.0625;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số âm mũ chẳn
     @Test
    public void TestMuAm3(){
         double x = -2.0;
        int n = -2;
        double expected = 0.25;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Số âm mũ lẻ 
     @Test
    public void TestMuAm4(){
         double x = -2.0;
        int n = -3;
        double expected = -0.125;
        double actual = DeQuyServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    //Testoverflow
    @Test
    public void TestException(){
        double x = 9999;
        int n = 999999;
        Assertions.assertThrows(StackOverflowError.class, ()->{
            DeQuyServices.Power(x, n);
        });
    }
    
}
