package com.whz.springboot.learn.task;

import com.alibaba.fastjson.JSON;
import com.whz.springboot.learn.dao.UserInfoMapper;
import com.whz.springboot.learn.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 * @date 2018/8/25
 */
@Component
@Slf4j
public class ScheduleBujisn {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Scheduled(cron = "* * * * * *")
    public void progress(){

        Date date = null;
        File file = null;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        try {
            file = ResourceUtils.getFile("classpath:sql_last_value");
            List<String> strings = FileUtils.readLines(file,"utf-8");
            log.info(String.valueOf(file.exists()));
            log.info(file.getName());
            if(strings != null &&strings.size() >0){
                date=format.parse(strings.get(0));
            }else{
                date=format.parse("2017-01-01 00:00:00.000000");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        List<UserInfo> userInfos = userInfoMapper.selectByCondition(date);
        userInfos.parallelStream().forEach(p ->{
            System.out.println(JSON.toJSONString(p));
        });
        if(userInfos.size() >0){
            UserInfo userInfo = userInfos.get(userInfos.size() - 1);
            try {
                FileUtils.writeStringToFile(file,format.format(userInfo.getRegtime()),"utf-8");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

    }
}
