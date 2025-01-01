
package com.trantheanh1301.pojo;

import java.util.UUID;


public class Question {
    private String id;
    private String content;
    private int category_id; 

    {
        setId(UUID.randomUUID().toString());
    }

    public Question() {
    }

//Nhớ bỏ id đi    
    public Question(String content, int category_id) {
        this.content = content;
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
   
    
}
