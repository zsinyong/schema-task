package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <b>@Author:</b>        jlliu3 <br/>
 * <b>@Version:</b>       1.0.1 <br/>
 * <b>@CreateTime:</b>    2018/2/27 16:31 <br/>
 * <b>@Copyright</b>     @Copyright (c) 2018 by iflytek <br/>
 * <b>@Description</b>   etl测试工具 <br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class GclpEtlTest {

    Logger logger = LoggerFactory.getLogger(GclpEtlTest.class);

    @Test
    public void readEpas() {
        logger.info("--------------定时任务开始--------------------");
        synchronized (GclpEtlTest.class) {
            try {
                GclpEtlTest.class.wait();
            } catch (Throwable e) {

            }

        }
    }
}
