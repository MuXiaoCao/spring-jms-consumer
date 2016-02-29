package dao;

import java.util.List;

import vo.Student;

public interface StuDao {
	public int addStu(Student s);
	public Student findStu(String xh,String psd);
	public List<Student> findStus();
}
