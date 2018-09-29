package com.ssm.persist;

import com.ssm.model.DO.CityDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 17:48
 * @description:
 */
public interface CityMapper {

    /**
     * 添加城市信息
     */
    Long addCity(CityDO cityDO);

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    CityDO selectByName(@Param("cityName") String cityName);

    /**
     * 根据城市id，查询城市信息
     *
     * @param id 城市名
     */
    CityDO selectById(@Param("id") Long id);


    /**
     * 根据省份ID查询城市
     */
    List<CityDO> selectCityByProvinceId(Long provinceId);
}
