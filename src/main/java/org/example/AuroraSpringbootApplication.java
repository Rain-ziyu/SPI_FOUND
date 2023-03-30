package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author RainZiYu
 * @Date 2023/3/30
 */

@SpringBootApplication
@MapperScans({@MapperScan("asia.huayu.mapper")})
public class AuroraSpringbootApplication extends SpringBootServletInitializer implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AuroraSpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuroraSpringbootApplication.class);
    }


    @Override
    public void run(String... args) throws Exception {
        //
    }
}