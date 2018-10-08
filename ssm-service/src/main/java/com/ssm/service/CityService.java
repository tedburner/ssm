package com.ssm.service;

import com.ssm.model.DO.CityDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:50
 * @description:
 */
public interface CityService {

    /**
     * 根据省份查询城市信息
     *
     * @param provinceId
     */
    List<CityDO> findCityList(Long provinceId);
}
