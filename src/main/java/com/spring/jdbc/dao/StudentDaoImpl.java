package com.spring.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")

public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		
		String query="insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
	}

	public int change(Student student) {
		
		String query="update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
	}

	public int delete(int studentId) {
		String query="delete from student where id=?";
		int result = this.jdbcTemplate.update(query,studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		
		String query="select *from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student s1 = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return s1;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String query="select *from student";
		List<Student> list = this.jdbcTemplate.query(query, new RowMapperImpl());
		return list;
	}
		
}
