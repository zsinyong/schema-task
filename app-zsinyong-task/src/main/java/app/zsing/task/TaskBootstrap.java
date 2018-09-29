package app.zsing.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskBootstrap {

    private static Logger logger = LoggerFactory.getLogger(TaskBootstrap.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/spring/spring-context.xml");
        applicationContext.start();
        logger.info("--------------定时任务启动成功--------------------");
        synchronized (TaskBootstrap.class) {
            while (true) {
                try {
                    TaskBootstrap.class.wait();
                } catch (InterruptedException e) {
                    logger.error("== synchronized error:", e);
                }
            }
        }
    }
}
