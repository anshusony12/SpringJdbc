package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
      
    	System.out.println("my programme has been started....");
    	
    	//spring jdbc template
    	ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	
//    	Student student=new Student();
//    	student.setId(454544);
//    	student.setName("Meera");
//    	student.setCity("New Delhi");
//  	
//    	int result = studentDao.insert(student);
//    	System.out.println("students added: "+result);  
    	
////    	Student student=new Student();
////    	
////    	int deleted = studentDao.delete(46);
////    	System.out.println("data deleted:"+deleted);
////    	
//    	Student student = studentDao.getStudent(456);
//    	System.out.println(student);
    	
    	List<Student> list = studentDao.getAllStudents();
    	
    	for(Student s: list) {
    		System.out.println(s);
    	}
    	
    }
}
