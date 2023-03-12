package fi.haagahelia.course.StudentListSecureDB.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastName);
    
}