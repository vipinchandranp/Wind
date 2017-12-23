package com.nuttron.quasar.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import com.nuttron.quasar.model.Address;
import com.nuttron.quasar.model.College;
import com.nuttron.quasar.model.Department;
import com.nuttron.quasar.model.Subject;
import com.nuttron.quasar.model.University;
import com.nuttron.quasar.util.PersistenceManager;

public class Main {
	public static void main(String[] args) {
		
		Address address = new Address();
		address.setLine1("mumbai");
		
		Address address1 = new Address();
		address1.setLine1("kannur");
		
		University university = new University();
		university.setAddress(address1);
		university.setName("MG");
		university.setColleges(new HashSet<College>());
		
		College college = new College();
		college.setName("MATHA");
		college.setAddress(address);
		
		university.getColleges().add(college);
		
		Subject subject = new Subject();
		subject.setName("maths");
		
		Department department = new Department();
		department.setName("cs");
		department.setSubjects(new HashSet<Subject>());
		department.getSubjects().add(subject);
		
		college.setDepartments(new HashSet<Department>());
		college.getDepartments().add(department);
		
		EntityDAO dao = new EntityDAOImpl();
		try {
			List<University> entity = dao.getEntity(university);
			for(University a : entity) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+ a.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
}