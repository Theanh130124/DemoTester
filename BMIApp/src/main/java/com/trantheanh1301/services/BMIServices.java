/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

/**
 *
 * @author LAPTOP
 */
//Các hàm tính toán thì tách thành services như vậy để có thể test

//Truyền qua bên PrimaryController 
public class BMIServices {
    public static int TinhBMI(double ChieuCao , double CanNang){
        double bmi = CanNang/Math.pow(ChieuCao,2);
        if (bmi < 18.5){
            return 1 ;
        }
        else if(bmi <25){
            return 2;
        }
        return 3;
    }
}
