package test;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDAO;
import entity.Dept;

public class TestCase2 {
	private DeptDAO dao;
	@Before
	public void init() {
		String config="mybatis-spring.xml";
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("deptDAO",DeptDAO.class);
	}
	
	@Test
	public void test1() {
		Dept dp=new Dept();
		dp.setDeptName("DEVELOPER");
		dp.setLoc("HangZhou");
		dao.insert(dp);
	}
	
	@Test
	public void test2() {
		List<Dept> dps=dao.findAll();
		System.out.println(dps);
	}
	
	@Test
	public void test3() {
		Dept dp=dao.findById(3);
		System.out.println(dp);
	}
	
	@Test
	public void test4() {
		Dept dp=dao.findById(3);
		dp.setDeptName("SERVICE");
		dao.update(dp);
	}
	
	@Test
	public void test5() {
		dao.delete(3);
	}
}
