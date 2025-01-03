


package com.trantheanh1301.pojo;


public class Category {
    private int id;
    private String name;

//Ctrl + Space

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    
    
    
    //Chuột trái ->Refactor -> Encapsulate Fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
    
    
}
