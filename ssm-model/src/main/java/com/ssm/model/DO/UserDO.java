package com.ssm.model.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: Lucifer
 * @date: 2018/10/26 14:46
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

    private Long id;

    private String name;

    private Integer age;

    private String password;

    private String card;

    private String phone;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
