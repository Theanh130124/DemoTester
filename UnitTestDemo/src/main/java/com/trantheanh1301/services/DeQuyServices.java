/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

/**
 *
 * @author LAPTOP
 */
public class DeQuyServices {
    public static double Power(double x , int n){
        if( n==0)
        {
            return 1.0;
        }
        else if( n > 0){
            return x* Power(x,n-1); //Đã sữa lỗi khi chạy lại  test case
            
        }
        else 
        {
            return 1/Power(x,-n); //Đã sữa khi chạy test case mũ âm
        }
    }
}
