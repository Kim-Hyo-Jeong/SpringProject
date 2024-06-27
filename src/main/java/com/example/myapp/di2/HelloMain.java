package com.example.myapp.di2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext(HelloMain.class, "application-config.xml");
		HelloController controller = 
				context.getBean("helloController", HelloController.class);
		controller.hello("ABCD");
		context.close();
	}
}