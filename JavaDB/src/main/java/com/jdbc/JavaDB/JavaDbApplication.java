package com.jdbc.JavaDB;

import com.jdbc.JavaDB.models.Student;
import com.jdbc.JavaDB.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JavaDbApplication {

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(JavaDbApplication.class, args);
		/*Student student = c.getBean(Student.class);
		System.out.println(student.getName());*/


		Student s = c.getBean(Student.class);

		/*s.setRollno(101);
		s.setName("Pablo");
		s.setMarks(78);
		*/

		StudentService studentService = c.getBean(StudentService.class);

		studentService.addStudents(s);
		List<Student> students = studentService.getStudents();
		System.out.println(students);

		//studentService.addStudents(s);

	}

}
