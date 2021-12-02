package cn.example.onethymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.Nullable;
import org.springframework.web.SpringServletContainerInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

@SpringBootApplication
@MapperScan("cn.example.onethymeleaf.dao")
public class OneThymeleafApplication extends SpringServletContainerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OneThymeleafApplication.class, args);
    }

}
