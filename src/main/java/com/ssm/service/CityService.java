package com.ssm.service;

import com.ssm.damain.DO.CityDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 15:14
 * @description:
 */
public interface CityService {

    /**
     * 根据省份ID查询城市信息
     *
     * @param provinceId
     */
    List<CityDO> findCityListByProvinceId(Long provinceId);
}
