package com.caseStudy.Ecommerce.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private  String firstname;
    private String lastname;
    private long phnno ;
    private String role;
    @Column(nullable = false)
    private String email;
    private String password;
    @Column(nullable = false,columnDefinition = "int default '1'")
    private int active;
    public Users()
    {

    }
    public Users(String firstname, String lastname, long phnno, String email, String password, int active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phnno = phnno;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getPhnno() {
        return phnno;
    }

    public void setPhnno(long phnno) {
        this.phnno = phnno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
