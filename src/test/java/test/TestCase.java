package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private EmployeeDAO dao;
	@Before
	public void init() {
		String config="mybatis-spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	public void test1() {

		Employee emp=new Employee();
		emp.setName("÷");
		emp.setAge(21);
		emp.setSalary(111111);
		dao.save(emp);
	}
	
	@Test
	public void test2() {
		List<Employee> employees=dao.findAll();
		System.out.println(employees);
	}
}
