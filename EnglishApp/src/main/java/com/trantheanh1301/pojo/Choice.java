/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.pojo;

import java.util.UUID;

/**
 *
 * @author LAPTOP
 */
public class Choice {
    private String id ;
    private String choice;
    private Boolean is_correct;
    private String question_id;
    
    {
        setId(UUID.randomUUID().toString());
    }

    public Choice() {
    }
//Nhớ bỏ id đi

    public Choice(String choice, Boolean is_correct, String question_id) {
        this.choice = choice;
        this.is_correct = is_correct;
        this.question_id = question_id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the choice
     */
    public String getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(String choice) {
        this.choice = choice;
    }

    /**
     * @return the is_correct
     */
    public Boolean getIs_correct() {
        return is_correct;
    }

    /**
     * @param is_correct the is_correct to set
     */
    public void setIs_correct(Boolean is_correct) {
        this.is_correct = is_correct;
    }

    /**
     * @return the question_id
     */
    public String getQuestion_id() {
        return question_id;
    }

    /**
     * @param question_id the question_id to set
     */
    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }
    
    
   
    
}
