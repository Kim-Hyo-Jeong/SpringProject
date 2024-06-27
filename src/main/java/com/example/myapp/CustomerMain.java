package com.example.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext(CustomerMain.class, "application-config.xml");
		Customer cust = context.getBean(Customer.class);
		System.out.println(cust);
	}
}
