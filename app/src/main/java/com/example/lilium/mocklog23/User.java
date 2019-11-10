package com.example.lilium.mocklog23;

public class User {
    String Email;
    String Name;
    String UserType;


public User(){
}

public User(String Email, String Name, String UserType){
    this.Email = Email;
    this.Name = Name;
    this.UserType = UserType;
}

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public String getUserType() {
        return UserType;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}