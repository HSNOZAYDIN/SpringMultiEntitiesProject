package com.huseyinoz.controller;

import java.util.List;

import com.huseyinoz.dto.DtoStudent;
import com.huseyinoz.dto.DtoStudentIU;
import com.huseyinoz.entites.Student;

public interface IStudentController {

	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);
}

