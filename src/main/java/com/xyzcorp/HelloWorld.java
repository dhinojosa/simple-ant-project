package com.xyzcorp;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloWorld {

    private String name;

    public String greet() {
        return "success";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}