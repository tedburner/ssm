package com.ssm.controller;

import com.ssm.common.utils.http.NewResponseModel;
import com.ssm.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/30 14:46
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/address/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "getCity", method = RequestMethod.GET)
    public NewResponseModel getCity(@RequestParam("provinceId") Long provinceId) {
        NewResponseModel responseModel = NewResponseModel.Success();
        responseModel.setData(addressService.findCityList(provinceId));
        log.info("NewResponseModel:" + responseModel);
        return responseModel;
    }
}
