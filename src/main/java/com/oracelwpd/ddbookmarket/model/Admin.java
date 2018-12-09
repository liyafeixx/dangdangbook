package com.oracelwpd.ddbookmarket.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Admin implements Serializable{
    private int id;
    @NotNull//规定不能为null
    @Size(min = 2,max = 20)//规定最小值和最大值
    private String name;
    @NotNull//规定不能为null
    @Size(min = 2,max = 20)//规定最小值和最大值
    private String pwd;
    public Admin (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
