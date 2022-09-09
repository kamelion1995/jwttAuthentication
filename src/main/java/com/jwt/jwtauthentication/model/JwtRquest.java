package com.jwt.jwtauthentication.model;

public class JwtRquest {

    private String username;
    private String password;

    public JwtRquest() {
    }

    public JwtRquest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtRquest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
