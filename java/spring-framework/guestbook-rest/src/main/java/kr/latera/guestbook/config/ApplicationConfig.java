package kr.latera.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DBConfig.class)
@ComponentScan(basePackages = {"kr.latera.guestbook.dao", "kr.latera.guestbook.service"})
public class ApplicationConfig {

}
