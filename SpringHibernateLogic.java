package com.mondee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringHibernateLogic implements CommandLineRunner {
	
	
	@Autowired
	private EmployeeDao dao;
	public static void main(String[] args) {
		
    ConfigurableApplicationContext ca= SpringApplication.run(SpringHibernateLogic.class, args);
    

	}
	public void run(String...args) throws Exception {
		
		Employee emp=new Employee();
		emp.setId(1034);
        emp.setName("shiva");
        emp.setSalary(43000);
        dao.insert(emp);
        System.out.println("\n\t Employee Data \n");
		dao.select();

		dao.delete(2);

		dao.select();
}
}
