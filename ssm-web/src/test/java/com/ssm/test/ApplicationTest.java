package com.ssm.test;

import com.ssm.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 15:24
 * @description:
 */
public class ApplicationTest extends BaseTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void findCityTest() {
        System.out.println(addressService.findCityList(2L));
    }
}
