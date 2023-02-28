package com.controller;

import com.dto.Student;
import com.factory.StudentServiceFactory;
import com.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
	IStudentService stdService;

	@Override
	public String save(Student student) {
		stdService=StudentServiceFactory.getStudentService();
		System.out.println("Implementation class is ::"+stdService.getClass().getName());
		return stdService.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		System.out.println("inside controller");
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		System.out.println("inside controller");
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		System.out.println("inside controller");
		return stdService.deleteById(sid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
