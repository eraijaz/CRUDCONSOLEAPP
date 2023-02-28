package com.service;

import com.dao.IStudentDao;
import com.dto.Student;
import com.factory.StudentDaoFactory;
import com.factory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {
	IStudentDao stdDao;
	

	@Override
	public String save(Student student) {
		stdDao=StudentDaoFactory.getStudentDao();
		System.out.println("implementataion class is::"+stdDao.getClass().getName());
		return stdDao.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		System.out.println("inside service");
		return stdDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		System.out.println("inside service");
		return stdDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		System.out.println("inside controller");
		return stdDao.deleteById(sid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
