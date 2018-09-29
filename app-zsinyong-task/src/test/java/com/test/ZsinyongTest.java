package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class ZsinyongTest {

    Logger logger = LoggerFactory.getLogger(ZsinyongTest.class);

    @Test
    public void readEpas() {
        logger.info("--------------定时任务开始--------------------");
        synchronized (ZsinyongTest.class) {
            try {
                ZsinyongTest.class.wait();
            } catch (Throwable e) {

            }

        }
    }
}
