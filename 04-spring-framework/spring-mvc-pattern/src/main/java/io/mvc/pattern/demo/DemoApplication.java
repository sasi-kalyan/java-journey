package io.mvc.pattern.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class DemoApplication {

    /*
            Spring MVC is a web framework that is built on the top of the MVC framework that
            uses the Front controller architecture to handle the http request effectiently.

            SingleFrontController = DispatcherServlet

            Browser -> DispatcherServlet -> Controller -> Service -> Repository -> Database

            Heart of the SpringMVC:
            DispatcherServlet is the Front Controller of Spring MVC that receives every request and delegates or maps
            it to the appropriate controller.

            Controller:
            	- Handles HTTP request/respose
            	- Path variables
            	- Request parms

            Service:
            	BusinessLogic
            	Rules
            	Calculations
            	Validations
            	Transactions

            Repository:
            	DB operations
            	CRUD
            	Queries

     */

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
