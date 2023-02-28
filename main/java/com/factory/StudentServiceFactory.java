package com.factory;

import com.service.IStudentService;
import com.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentServiceImpl studentService;
	private StudentServiceFactory()
	{
		
	}
	public static IStudentService getStudentService() {
		if (studentService==null)
			studentService=new StudentServiceImpl();
		return studentService;
		

}
}
