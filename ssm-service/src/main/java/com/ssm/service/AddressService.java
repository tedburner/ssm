package com.ssm.service;

import com.ssm.model.DO.CityDO;
import com.ssm.model.DO.ProvinceDO;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:50
 * @description:
 */
public interface AddressService {

    /**
     * 根据省份ID查询城市信息
     *
     * @param provinceId
     */
    List<CityDO> findCityList(Long provinceId);

    /**
     * 查询省份信息
     * */
    List<ProvinceDO> findProvinceList();
}
