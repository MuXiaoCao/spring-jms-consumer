package test.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.StuManager;
import vo.Student;

public class StuManagerImplTest {
	
	private static StuManager sm;
	
	@BeforeClass
	public static void beforeClass(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		sm=(StuManager)context.getBean("sm");
	}
	@Test
	public void testRegist() {
		Student s = new Student();
		
		s.setUname("xiaocao");
		s.setPsd("123");
		s.setSex(1);
		s.setXh("111");
		int id = sm.regist(s);
	}
}
