package kr.latera.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 
 * @author Jinwoo Shin
 * 
 * DB 설정 클래스
 * EnableTransactionManagerment은 Spring에서 트랜잭션 관리를 위해 달아주는 어노테이션
 * 이 어노테이션이 붙으면 트랜잭션 관리를 위해 PlatformTransactionManager 객체를 빈으로 만들어야 한다.
 * 이를 위해 클래스에서 TransactionManagementConfigurer 인터페이스의 annotationDrivenTransactionManager를 구현하면서
 * PlatformTransactionManager 빈을 반환하고 있다.
 */
@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer{
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/guestbook?useUnicode=true&characterEncoding=utf8";
	
	private static final String USER = "admin_guestbook";
	private static final String PW = "p@ssW0rd";

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USER);
		dataSource.setPassword(PW);
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
}
