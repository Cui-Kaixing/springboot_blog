package com.ckx.domain;


import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/9/23.
 */
public class User {
    private Long id;
    private String nikeName;
    private String username;
    private String passWord;
    private String email;
    private Integer type;//用户类型
    private Date creatTime;
    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nikeName='" + nikeName + '\'' +
                ", username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", creatTime=" + creatTime +
                ", blogs=" + blogs +
                '}';
    }
}
