package com.ssm.service.impl;

import com.ssm.damain.DO.CityDO;
import com.ssm.persist.CityMapper;
import com.ssm.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 15:15
 * @description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;


    @Override
    public List<CityDO> findCityListByProvinceId(Long provinceId) {

        return cityMapper.selectCityByProvinceId(provinceId);
    }
}
