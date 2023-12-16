package com.spring.orm.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.springorm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {	
		return (Integer) hibernateTemplate.save(student);
	}
	
	public Student getStudent(int studentId) {
		return hibernateTemplate.get(Student.class, studentId);
	}
	
	public List<Student> getAllStudents(){
		return hibernateTemplate.loadAll(Student.class);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class,studentId);
		hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
