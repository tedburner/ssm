package com.ssm.test;

import com.ssm.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 15:24
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ApplicationTest {

    @Autowired
    private CityService cityService;

    @Test
    public void findCityTest() {
        System.out.println(cityService.findCityList(2L));
    }
}
