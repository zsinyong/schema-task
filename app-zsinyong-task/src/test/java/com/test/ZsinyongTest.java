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
    public void doSchemaTaskUnit() {
        logger.info("Starting to use schema task test unit");
        synchronized (ZsinyongTest.class) {
            try {
                ZsinyongTest.class.wait();
            } catch (Throwable e) {
                logger.info("执行定时任务异常.{}", e);
            }
        }
    }
}
