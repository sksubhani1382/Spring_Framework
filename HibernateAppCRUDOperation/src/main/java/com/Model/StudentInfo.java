package com.Model;

import javax.persistence.*;

@Entity
@Table(name = "studentinfo")
public class StudentInfo {

    @Id
    private int id;   // ✔ manual id entry

    private String firstname;
    private String middlename;
    private String lastname;

    public StudentInfo() {}

    public StudentInfo(int id, String firstname, String middlename, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    // getters + setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getMiddlename() { return middlename; }
    public void setMiddlename(String middlename) { this.middlename = middlename; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}
