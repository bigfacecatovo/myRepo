package cn.jhc.dao;

import java.util.List;

import cn.jhc.entity.Student;

public interface StudentMapper {
	public List<Student> select();
	public int delete(Integer id);
	public void insert(Student s);
	public void update(Student s);
	public void insertMajor(Student s);
	public List<Student> findByName(Student s);
	public List<Student> find(Student s);
	public void updateOne(Student s);
	
	public List<Student> findByIds(List<Integer> ids);
	public List<Student> findInIds(List<Integer> ids);
	public List<Student> findBind(Student s);
	public List<Student> findChoose(Student s);
}
