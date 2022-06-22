package com.first.shop2206.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username,e_mail,phoneNumber,password;

    public User(Long id, String username, String e_mail, String phoneNumber, String password) {
        this.id = id;
        this.username = username;
        this.e_mail = e_mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password, String e_mail, String phoneNumber) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


