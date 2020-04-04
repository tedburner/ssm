package com.ssm.service.impl;

import com.ssm.common.aspect.AnnotationServiceCase;
import com.ssm.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/4 22:07
 * @description:
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {


    @Override
    @AnnotationServiceCase
    public void testAop() {
        log.info("进入 Service 层 ...");
    }
}
