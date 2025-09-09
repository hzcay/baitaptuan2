package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "[User]")
@SuppressWarnings("serial")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "email", columnDefinition = "NVARCHAR(255)")
    private String email;
    
    @Column(name = "username", columnDefinition = "NVARCHAR(50)")
    private String userName;
    
    @Column(name = "fullname", columnDefinition = "NVARCHAR(100)")
    private String fullName;
    
    @Column(name = "password", columnDefinition = "NVARCHAR(100)")
    private String passWord;
    
    @Column(name = "avatar", columnDefinition = "NVARCHAR(255)") 
    private String avatar;
    
    @Column(name = "roleid")
    private int roleid;
    
    @Column(name = "phone", columnDefinition = "NVARCHAR(20)")
    private String phone;
    
    @Column(name = "createddate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public User() {

    }

    public User(int id, String email, String userName, String fullName, String passWord, String avatar, int roleid, String phone, Date createdDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.passWord = passWord;
        this.avatar = avatar;
        this.roleid = roleid;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public User(String email, String userName, String fullName, String passWord, String avatar, int roleid, String phone, Date createdDate) {
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.passWord = passWord;
        this.avatar = avatar;
        this.roleid = roleid;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }
    
    // ✅ Alias for JSP ${account.username}
    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
