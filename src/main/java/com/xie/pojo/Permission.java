package com.xie.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}