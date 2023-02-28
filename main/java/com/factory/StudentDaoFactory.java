package com.factory;

import com.dao.IStudentDao;
import com.dao.StudentDaoImpl;
import com.service.IStudentService;
import com.service.StudentServiceImpl;

public class StudentDaoFactory {
	private static StudentDaoImpl studentDao=null;
	private StudentDaoFactory()
	{
		
	}
	public static IStudentDao getStudentDao() {
		if (studentDao==null)
			studentDao=new StudentDaoImpl();
		return studentDao;
		

}

}
