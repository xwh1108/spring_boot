package com.xie.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;
}