package com.jike.crazyeveryday.bean;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 逆地理编码请求参数
 */
@Component
@Data
public class GeoCodePara {
    /**
    * 高德Key 不为空
     */
    private String key;

    //传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位。
    /**
     * 不为空
     */
    private String location;

    // 返回附近POI类型
    private String poitype;

    // 搜索半径 radius取值范围在0~3000，默认是1000。单位：米
    private String radius;

    /**
     * 返回结果控制
     * extensions 参数默认取值是 base，也就是返回基本地址信息；
     * extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
     */
    private String extensions;

    /**
     * 道路等级
     * 以下内容需要 extensions 参数为 all 时才生效。
     * 可选值：0，1
     * 当roadlevel=0时，显示所有道路
     * 当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
     */
    private String roadlevel;

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

    /**
     * 是否优化POI返回顺序
     * 以下内容需要 extensions 参数为 all 时才生效。
     *
     * homeorcorp 参数的设置可以影响召回 POI 内容的排序策略，目前提供三个可选参数：
     *
     * 0：不对召回的排序策略进行干扰。
     *
     * 1：综合大数据分析将居家相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     *
     * 2：综合大数据分析将公司相关的 POI 内容优先返回，即优化返回结果中 pois 字段的poi顺序。
     */
    private String homeorcorp;


}
