package com.example.myapp.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HumanResourceController {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(
				HumanResourceController.class, "application-config.xml");
		HumanResourceRepository repo = (HumanResourceRepository) context.getBean("repo");
//		List<Employee> list = repo.getEmpList();
//		
//		for(Employee emp : list) {
//			System.out.println(emp);
//		}
//		System.out.println("종료");
		
		System.out.println("80번 부서의 사원 수 : " + repo.getEmpCount(80));
	}
}
