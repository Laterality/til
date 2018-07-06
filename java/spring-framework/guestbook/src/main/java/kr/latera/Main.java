package kr.latera;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.latera.guestbook.config.ApplicationConfig;
import kr.latera.guestbook.dao.LogDao;
import kr.latera.guestbook.dto.Log;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		LogDao logDao = ac.getBean(LogDao.class);
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);	

	}

}
