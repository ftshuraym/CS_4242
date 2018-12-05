package com.example.faisalshuraym.practice_side_bar;

public class User {
    String email;
    String phone;

    //User Initialize
    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    //User contractor
    public User(){

    }

    //You can get UserEmail from another classes.
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
