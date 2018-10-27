package com.ssm.model.dto;

import lombok.Data;

/**
 * @author: Lucifer
 * @date: 2018/10/27 11:15
 * @description:
 */
@Data
public class AddressDTO {

    private String name;

    private String description;

    private Long provinceId;
}
