package com.jike.crazyeveryday.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jike.crazyeveryday.bean.AroundPara;
import com.jike.crazyeveryday.config.GaoDeConfig;
import com.jike.crazyeveryday.serviceImpl.IndexServiceImpl;
import com.jike.crazyeveryday.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class IndexService implements IndexServiceImpl {

    @Autowired
    GaoDeConfig gaoDeConfig;

    @Override
    public String findLocation(String position) {
       return findParamsBuild(position);
    }

    @Override
    public String findLocationBySearchName(String search) {
        return findParamsBuild(search);
    }

    private String findParamsBuild(String requestParams){
        AroundPara aroundPara = new AroundPara();
        JSONObject jsonObject = JSONObject.parseObject(requestParams);
        aroundPara.setKey(gaoDeConfig.getKey());
        // 搜索半径 设置成2000米
        aroundPara.setRadius("2000");
        // 拿到经纬度
        aroundPara.setLocation(jsonObject.getString("longitude")+","+jsonObject.getString("latitude"));
        if (StringUtils.hasText(jsonObject.getString("searchName"))){
            aroundPara.setKeywords(jsonObject.getString("searchName"));
        }else{
            aroundPara.setKeywords("肯德基");
        }
        String aroundResult =  HttpClientUtil.get(gaoDeConfig.getAroundurl(), JSONObject.parseObject(JSONObject.toJSONString(aroundPara)));
        //String aroundResult ="{\"count\":\"4\",\"infocode\":\"10000\",\"pois\":[{\"parent\":\"B0FFGECE4P\",\"address\":\"长江西路与怀宁路交叉口北京华联购物中心F2层\",\"distance\":\"1227\",\"pcode\":\"340000\",\"adcode\":\"340104\",\"pname\":\"安徽省\",\"cityname\":\"合肥市\",\"type\":\"餐饮服务;快餐厅;肯德基\",\"typecode\":\"050301\",\"adname\":\"蜀山区\",\"citycode\":\"0551\",\"name\":\"肯德基(北京华联长江西路购物中心店)\",\"location\":\"117.222192,31.854508\",\"id\":\"B02270JPHK\"},{\"parent\":\"B0I1RXC3MJ\",\"address\":\"望江西路与潜山路交口港汇广场1层\",\"distance\":\"1391\",\"pcode\":\"340000\",\"adcode\":\"340104\",\"pname\":\"安徽省\",\"cityname\":\"合肥市\",\"type\":\"餐饮服务;快餐厅;肯德基\",\"typecode\":\"050301\",\"adname\":\"蜀山区\",\"citycode\":\"0551\",\"name\":\"肯德基(港汇中心店)\",\"location\":\"117.232068,31.833400\",\"id\":\"B0FFFS3QDG\"},{\"parent\":\"B0FFJ12CU5\",\"address\":\"长江西路478号合肥弘阳广场F1层\",\"distance\":\"1561\",\"pcode\":\"340000\",\"adcode\":\"340104\",\"pname\":\"安徽省\",\"cityname\":\"合肥市\",\"type\":\"餐饮服务;快餐厅;肯德基\",\"typecode\":\"050301\",\"adname\":\"蜀山区\",\"citycode\":\"0551\",\"name\":\"肯德基(合肥弘阳广场店)\",\"location\":\"117.236911,31.851660\",\"id\":\"B0HRPC5SHF\"},{\"parent\":\"B0227159EB\",\"address\":\"潜山路与望江西路交叉口乐购超市一楼肯德基\",\"distance\":\"1572\",\"pcode\":\"340000\",\"adcode\":\"340104\",\"pname\":\"安徽省\",\"cityname\":\"合肥市\",\"type\":\"餐饮服务;快餐厅;肯德基\",\"typecode\":\"050301\",\"adname\":\"蜀山区\",\"citycode\":\"0551\",\"name\":\"肯德基(大唐国际购物广场店)\",\"location\":\"117.232491,31.831671\",\"id\":\"B02270JO3J\"}],\"status\":\"1\",\"info\":\"OK\"}";
        JSONObject aroundJsonObject = JSONObject.parseObject(aroundResult);
        System.out.println("aroundJsonObject:"+aroundJsonObject);
        JSONArray pois = aroundJsonObject.getJSONArray("pois");
        System.out.println("pois:"+pois);
        if (CollectionUtils.isEmpty(pois)){
            return "";
        }else{
            return JSONObject.toJSONString(pois);
        }
    }

}
