package com.ssm.controller;

import com.ssm.utils.http.NewResponseModel;
import javafx.scene.chart.ValueAxis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/29 14:33
 * @description:
 */
@RestController
@RequestMapping(value = "/city/")
public class CityController {

    @RequestMapping(value = "getCityByProvinceId", method = RequestMethod.GET)
    public NewResponseModel getCity(Long provinceId) {
        NewResponseModel responseModel = NewResponseModel.Success();

        return responseModel;
    }
}
