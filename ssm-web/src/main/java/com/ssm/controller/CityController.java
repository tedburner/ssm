package com.ssm.controller;

import com.ssm.common.utils.http.NewResponseModel;
import com.ssm.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:46
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/city/")
public class CityController {


    @Autowired
    private CityService cityService;

    @RequestMapping(value = "getCityByProvinceId")
    public NewResponseModel getCity(@RequestParam("provinceId") Long provinceId) {
        NewResponseModel responseModel = NewResponseModel.Success();
        responseModel.setData(cityService.findCityList(provinceId));
        log.info("NewResponseModel:" + responseModel);
        return responseModel;
    }
}
