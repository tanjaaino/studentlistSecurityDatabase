package fi.haagahelia.course.StudentListSecureDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.StudentListSecureDB.domain.Department;
import fi.haagahelia.course.StudentListSecureDB.domain.DepartmentRepository;
import fi.haagahelia.course.StudentListSecureDB.domain.Student;
import fi.haagahelia.course.StudentListSecureDB.domain.StudentRepository;
import fi.haagahelia.course.StudentListSecureDB.domain.User;
import fi.haagahelia.course.StudentListSecureDB.domain.UserRepository;

@SpringBootApplication
public class StudentListSecureDBApplication {
	
	private static final Logger log = LoggerFactory.getLogger(StudentListSecureDBApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentListSecureDBApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner studentDemo(StudentRepository srepository, DepartmentRepository drepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of students");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Business"));
			drepository.save(new Department("Law"));
			
			srepository.save(new Student("John", "Johnson", "john@john.com", drepository.findByName("IT").get(0)));
			srepository.save(new Student("Katy", "Kateson", "kate@kate.com", drepository.findByName("Business").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all students");
			for (Student student : srepository.findAll()) {
				log.info(student.toString());
			}

		};
	}

}
