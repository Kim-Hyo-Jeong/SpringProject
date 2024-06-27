package com.example.myapp.di;

// p.10
public class HelloMain {
	public static void main(String[] args) {
		IHelloService helloService = new HelloService();
		HelloController controller = new HelloController(helloService);
		controller.hello("ȫ�浿");
	}
}