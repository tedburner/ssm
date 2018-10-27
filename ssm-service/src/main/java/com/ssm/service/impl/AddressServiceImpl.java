package com.ssm.service.impl;

import com.ssm.model.DO.CityDO;
import com.ssm.model.DO.ProvinceDO;
import com.ssm.model.dto.AddressDTO;
import com.ssm.persist.CityMapper;
import com.ssm.persist.ProvinceMapper;
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
    @Resource
    private ProvinceMapper provinceMapper;


    @Override
    public List<CityDO> findCityList(Long provinceId) {
        return cityMapper.selectCityByProvinceId(provinceId);
    }

    @Override
    public List<ProvinceDO> findProvinceList() {
        return provinceMapper.selectProvince();
    }

    @Override
    public void addProvince(String name) {
        provinceMapper.addProvince(name);
    }

    @Override
    public void saveCity(AddressDTO address) {
        CityDO cityDO = CityDO.builder()
                .name(address.getName())
                .provinceId(address.getProvinceId())
                .description(address.getDescription())
                .build();
        cityMapper.addCity(cityDO);
    }
}
