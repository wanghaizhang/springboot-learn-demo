package com.whz.springboot.learn.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private String id;
    private String name;
    private String passwd;
    private Date regtime;
}