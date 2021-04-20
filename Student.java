package com.company;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String FirstName;
    private String LastName;
    private int Age;

    public Student(){
    }

    public Student(int id, String FirstName, String LastName, int Age){
        super();
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAge(int age) {
        Age = age;
    }

}
