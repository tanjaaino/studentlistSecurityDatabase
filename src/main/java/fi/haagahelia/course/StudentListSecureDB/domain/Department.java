package fi.haagahelia.course.StudentListSecureDB.domain;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Student> students;
	
	public Department() {}
	
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Long getDepartmentid() {
		return departmentid;
	}
	
	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", name=" + name + "]";
	}
}
