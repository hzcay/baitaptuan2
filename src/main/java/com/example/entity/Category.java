package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int cateid;
    
    @Column(name = "cate_name", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String catename;
    
    @Column(name = "icons", columnDefinition = "NVARCHAR(500)")
    private String icon;
    
    // ✅ Simple user_id relationship (not full JPA relationship)
    @Column(name = "user_id", nullable = false)
    private int userId;
    
    public Category() {
    }

    public Category(String catename, String icon, int userId) {
        this.catename = catename;
        this.icon = icon;
        this.userId = userId;
    }
    
    public Category(int cateid, String catename, String icon, int userId) {
        this.cateid = cateid;
        this.catename = catename;
        this.icon = icon;
        this.userId = userId;
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
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return "Category [cateid=" + cateid + ", catename=" + catename + ", icon=" + icon + ", userId=" + userId + "]";
    }
}
