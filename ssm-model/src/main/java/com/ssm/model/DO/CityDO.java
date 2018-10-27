package com.ssm.model.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 17:51
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDO {

    private Long id;

    private String name;

    private Long provinceId;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
