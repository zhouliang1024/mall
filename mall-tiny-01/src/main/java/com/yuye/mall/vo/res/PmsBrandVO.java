package com.yuye.mall.vo.res;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhouliangimplements Serializable
 * @Date: 2020/9/24 21:43
 */
@Data
public class PmsBrandVO implements Serializable {
    private Long id;

    private String name;

    /**
     * 首字母
     *
     * @mbg.generated
     */
    private String firstLetter;

    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     *
     * @mbg.generated
     */
    private Integer factoryStatus;

    private Integer showStatus;

    /**
     * 产品数量
     *
     * @mbg.generated
     */
    private Integer productCount;

    /**
     * 产品评论数量
     *
     * @mbg.generated
     */
    private Integer productCommentCount;

    /**
     * 品牌logo
     *
     * @mbg.generated
     */
    private String logo;

    /**
     * 专区大图
     *
     * @mbg.generated
     */
    private String bigPic;

    /**
     * 品牌故事
     *
     * @mbg.generated
     */
    private String brandStory;
}
