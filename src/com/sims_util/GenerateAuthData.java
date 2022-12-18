package com.sims_util;

import com.sims_models.Auth;
import com.sims_models.Student;
import com.sims_models.Teacher;

public class GenerateAuthData {

	private static Auth auth = null;

	public static Auth generateStudentAuthData(Student student, String userState) {

		String username = student.getName() + student.getAge();
		String password = student.getName() + student.getGrade() + student.getClassName() + student.getAge();

		auth = new Auth(0, username, password, userState);

		return auth;
	}

	public static Auth generateTeacherAuthData(Teacher teacher, String userState) {

		String username = teacher.getName() + teacher.getAge();
		String password = teacher.getName() + teacher.getSbid() + teacher.getTid() + teacher.getAge();

		auth = new Auth(0, username, password, userState);

		return auth;
	}
}
