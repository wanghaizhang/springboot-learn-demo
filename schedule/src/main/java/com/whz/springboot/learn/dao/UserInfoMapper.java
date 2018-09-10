package com.whz.springboot.learn.dao;

import com.whz.springboot.learn.model.UserInfo;

import java.util.Date;
import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> selectByCondition(Date date);
}