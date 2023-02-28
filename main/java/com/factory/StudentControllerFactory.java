package com.factory;

import com.controller.IStudentController;
import com.controller.StudentControllerImpl;
import com.service.StudentServiceImpl;

public class StudentControllerFactory {
	private static StudentControllerImpl studentController=null;
	private StudentControllerFactory()
	{
		
	}
	public static IStudentController getStudentController() {
		if (studentController==null)
			studentController=new StudentControllerImpl();
		return studentController;
		
		
	}

}
