package com.ssm.web.controller;

import com.ssm.common.utils.http.ResponseModel;
import com.ssm.model.dto.AddressDTO;
import com.ssm.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "getProvince", method = RequestMethod.GET)
    public ResponseModel getProvince() {
        ResponseModel responseModel = ResponseModel.Success();
        responseModel.setData(addressService.findProvinceList());
        log.info("NewResponseModel:" + responseModel);
        return responseModel;
    }

    @RequestMapping(value = "getCity", method = RequestMethod.GET)
    public ResponseModel getCity(Long provinceId) {
        ResponseModel responseModel = ResponseModel.Success();
        responseModel.setData(addressService.findCityList(provinceId));
        log.info("NewResponseModel:" + responseModel);
        return responseModel;
    }

    @PostMapping("addProvince")
    public ResponseModel addProvince(@RequestBody AddressDTO address) {
        ResponseModel responseModel = ResponseModel.Success();
        addressService.addProvince(address.getName());
        return responseModel;
    }

    @PostMapping("addCity")
    public ResponseModel addCity(@RequestBody AddressDTO address) {
        ResponseModel responseModel = ResponseModel.Success();
        addressService.saveCity(address);
        return responseModel;
    }
}
