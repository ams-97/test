package com.example.lilium.mocklog23;

public class Member {
     String Name;
     String password;

    public Member() {
    }

    public Member(String Name,String password) {
        this.Name = Name;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
