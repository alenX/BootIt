package org.wangss.Models;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.persistence.*;

/**
 * Created by wangss on 2017/2/24.
 */

public class BootUser {
    private Long id;
    private String name;
    private String password;
    private String nickname;
    private boolean isOnline;

    public BootUser() {
    }

    public BootUser(String name, String password) {
        this.name = name;
        setPassword(password);
        this.isOnline = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassWord(String pw) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder();
        return sha.isPasswordValid(password, pw, null);
    }

    public void setPassword(String password) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder();
        sha.setEncodeHashAsBase64(false);
        this.password = sha.encodePassword(password, null);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}