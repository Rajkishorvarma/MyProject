package com.durgasoft.service;

import com.durgasoft.beans.Student;
import com.durgasoft.dao.StudentDao;
import com.durgasoft.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student  student =studentDao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.update(student);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.delete(sid);
		return status;
	}

}
