package com.example.my_first_java_for_android;

import com.google.gson.annotations.SerializedName;

public class Employee {
    /*
    private String firstName;
    private int age;
    private String mail;

    public Employee(String firstName, int age, String mail) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
    }
    */
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("age")
    private int mAge;
    @SerializedName("mail")
    private String mMail;

    public Employee(String firstName, int age, String mail) {
        mFirstName = firstName;
        mAge = age;
        mMail = mail;
    }
}
