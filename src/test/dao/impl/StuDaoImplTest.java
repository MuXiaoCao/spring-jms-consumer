package test.dao.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import vo.Student;
import dao.StuDao;
import dao.impl.StuDaoImpl;

public class StuDaoImplTest {
	private static StuDao sd;
	@BeforeClass
	public static void beforeClass(){
		sd=new StuDaoImpl();
	}
	
	@Test
	public void testFind(){
		Student s1=sd.findStu("003", "ddfdsfsdf");
		Student s2=sd.findStu("003", "ddfdsfsddfdf");
		Assert.assertTrue(s1!=null);
		Assert.assertTrue(s2==null);
		
		
		
	}
	@Test
	public void testAddStu(){
		Student s=new Student();
		s.setUname("John¿´");
		s.setXh("003");
		s.setSex(true);
		s.setGroupid(1);
		s.setPsd("ddfdsfsdf");
		
		int rs=sd.addStu(s);
		
		Assert.assertTrue(rs>=1);
	}
	
}
