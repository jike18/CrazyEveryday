package com.jike.crazyeveryday.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jike.crazyeveryday.bean.AroundPara;
import com.jike.crazyeveryday.config.GaoDeConfig;
import com.jike.crazyeveryday.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    IndexService indexService;


    @RequestMapping("hello")
    public String sayHello(){
        return "Crazy Everyday!";
    }

    @RequestMapping("findLocationBySearchName")
    public String findLocationByName(@RequestParam String searchParams){
        return indexService.findLocationBySearchName(searchParams);
    }

    @RequestMapping("findLocation")
    public String findLocation(@RequestParam String position){
        return indexService.findLocation(position);
    }
}
