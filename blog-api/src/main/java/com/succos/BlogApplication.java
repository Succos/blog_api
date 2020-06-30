package com.succos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author succos
 */
@SpringBootApplication
@MapperScan(basePackages="com.succos.mapper")
@ComponentScan(basePackages = {"com.succos","org.n3r.idworker"})
public class BlogApplication {
    static Logger logger = LoggerFactory.getLogger(BlogApplication.class);
    public static void main(String[] args) {
        try {
            SpringApplication.run(BlogApplication.class, args);
            logger.info("启动成功!");
        } catch (Exception e) {
            System.out.println(e);
            logger.error("启动异常", e);
        }
    }

}
