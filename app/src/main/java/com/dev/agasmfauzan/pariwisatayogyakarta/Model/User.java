package com.dev.agasmfauzan.pariwisatayogyakarta.Model;

public class User {
    private String username;
    private String password;
    private String email;

    public User(){ }

    public User(String username,String password,String email){
        this.email=email;
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
