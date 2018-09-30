package com.ssm.controller;

import com.ssm.common.utils.http.NewResponseModel;
import com.ssm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:46
 * @description:
 */
@RestController
@RequestMapping(value = "/city/")
public class CityController {

    @Autowired
    private CityService cityService;

    public NewResponseModel getCity(){
        NewResponseModel responseModel = NewResponseModel.Success();


        return responseModel;
    }
}
