package com.ssm.model.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: Lucifer
 * @date: 2018/10/26 14:36
 * @description:
 */
@Data
@AllArgsConstructor
@Builder
public class ProvinceDO {

    private Long id;

    private String name;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
