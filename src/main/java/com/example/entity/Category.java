package com.example.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int cateid;
    private String catename;
    private String icon;
    
    public Category() {
        super();
    }
    
    public Category(String catename, String icon) {
        super();
        this.catename = catename;
        this.icon = icon;
    }
    
    public Category(int cateid, String catename, String icon) {
        super();
        this.cateid = cateid;
        this.catename = catename;
        this.icon = icon;
    }
    
    public int getCateid() {
        return cateid;
    }
    
    public void setCateid(int cateid) {
        this.cateid = cateid;
    }
    
    public String getCatename() {
        return catename;
    }
    
    public void setCatename(String catename) {
        this.catename = catename;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    @Override
    public String toString() {
        return "Category [cateid=" + cateid + ", catename=" + catename + ", icon=" + icon + "]";
    }
}
