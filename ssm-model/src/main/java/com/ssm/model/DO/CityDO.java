package com.ssm.model.DO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 17:51
 * @description:
 */
@Data
public class CityDO {

    private Long id;

    private String name;

    private Long provinceId;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
