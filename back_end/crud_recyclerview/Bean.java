package com.example.practise_again;

public class Bean {

    Integer id;
    String name;
    String email;

    public Bean(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Bean(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
