package com.jike.crazyeveryday.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 根据经纬度周边搜索的请求实体
 */
@Data
@Component
public class AroundPara {
    /**
     * 高德Key 不为空
     */
    private String key;

    /**
     * 地点关键字
     * 需要被检索的地点文本信息。
     * 多个关键字用“|”分割，文本总长度不可超过80字符
     */
    private String keywords;

    /**传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位。
     * 不为空
     */
    private String location;

    /**
     * 指定地点类型
      */
    private String types;

    /**
     * 搜索半径
     * 取值范围:0-50000，大于50000时按默认值，单位：米
      */
    private String radius;


    /**
     * 排序规则
     * 规定返回结果的排序规则。
     * 按距离排序：distance(默认)；综合排序：weight
     */
    private String sortrule;

    /**
     * 搜索区划
     * 增加指定区域内数据召回权重，如需严格限制召回数据在区域内，请搭配使用city_limit参数，可输入行政区划名或对应citycode或adcode
     */
    private String region;

    /**
     * 指定城市数据召回限制
     * 可选值：true/false（默认）
     * 为true时，仅召回region对应区域内数据
     */
    private String city_limit;

    /**
     * 返回结果控制
     * show_fields用来筛选response结果中可选字段。show_fields的使用需要遵循如下规则：
     * 1、具体可指定返回的字段类请见下方返回结果说明中的“show_fields”内字段类型；
     * 2、多个字段间采用“,”进行分割；
     * 3、show_fields未设置时，只返回基础信息类内字段。
     */
    private String show_fields;

    /**
     * 当前分页展示的数据条数
     * page_size的取值1-25
     * 默认10
     */
    private String page_size;


    /**
     * 当前分页展示的数据条数
     * page_num的取值1-100
     * 默认1
     */
    private String page_num;

    /**
     * 数字签名 可以无
     */
    private String sig;

    /**
     * 返回数据格式类型
     *
     * 可选输入内容包括：JSON，XML。设置 JSON 返回结果数据将会以JSON结构构成；如果设置 XML 返回结果数据将以 XML 结构构成。
     */
    private String output;

    /**
     * 回调函数
     * callback 值是用户定义的函数名称，此参数只在 output 参数设置为 JSON 时有效。
     */
    private String callback;

}
