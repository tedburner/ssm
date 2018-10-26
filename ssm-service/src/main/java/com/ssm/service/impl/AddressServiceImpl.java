package com.ssm.service.impl;

import com.ssm.model.DO.CityDO;
import com.ssm.persist.CityMapper;
import com.ssm.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:50
 * @description:
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private CityMapper cityMapper;


    @Override
    public List<CityDO> findCityList(Long provinceId) {
        return cityMapper.selectCityByProvinceId(provinceId);
    }
}
