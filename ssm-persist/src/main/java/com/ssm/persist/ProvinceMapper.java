package com.ssm.persist;

import com.ssm.model.DO.CityDO;
import com.ssm.model.DO.ProvinceDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 17:48
 * @description:
 */
public interface ProvinceMapper {

    /**
     * 添加省份信息
     */
    Long addProvince(ProvinceDO provinceDO);

    /**
     * 根据省份名称，查询声明
     *
     * @param name 省份名
     */
    ProvinceDO selectByName(@Param("name") String name);

    /**
     * 根据省份ID，查询省份信息
     *
     * @param id 城市名
     */
    ProvinceDO selectById(@Param("id") Long id);


    /**
     * 查询省份信息
     */
    List<ProvinceDO> selectProvince();
}
