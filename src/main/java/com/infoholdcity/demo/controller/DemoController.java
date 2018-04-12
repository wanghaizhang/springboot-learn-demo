package com.infoholdcity.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author whz
 *@description
 *@modifiy By
 */
@RestController
@RequestMapping
@Api( value="用户controller",tags={"用户操作接口"})
public class DemoController {

    @ApiOperation(value="getKey", tags = {"获取用户信息"})
    @RequestMapping(value = "/getKey/{key}",method = RequestMethod.GET)
    public String getKey(@PathVariable String key){
        return key;
    }

}
