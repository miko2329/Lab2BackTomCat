package com.example.lab2backtomcat.classes;

public class User {
    private Integer id;
    private String privilege;

    private String login;
    private String password;


    public User() {
    }

    public User(Integer id, String privilege, String login, String password) {
        this.id = id;
        this.privilege = privilege;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
