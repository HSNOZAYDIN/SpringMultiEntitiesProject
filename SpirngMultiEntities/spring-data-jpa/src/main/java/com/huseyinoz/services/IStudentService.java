package com.huseyinoz.services;

import java.util.List;

import com.huseyinoz.dto.DtoStudent;
import com.huseyinoz.dto.DtoStudentIU;
import com.huseyinoz.entites.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);

	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	
	public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);
	
	
	
}
