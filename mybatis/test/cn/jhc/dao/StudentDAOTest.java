package cn.jhc.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.jhc.entity.Student;

public class StudentDAOTest {
	InputStream input;
	SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	StudentMapper dao;
	
	@Before
	public void init() throws IOException {
		input=Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
		session=sqlSessionFactory.openSession();
		dao=session.getMapper(StudentMapper.class);
	}
	
	@After
	public void destory() throws IOException{
		session.commit();
		session.close();
		input.close();
	}
	
	//@Test
	public void testSelect(){
		
		List<Student> l=dao.select();
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	
	//@Test
	public void testDelete() throws IOException{
		int ref=dao.delete(3);
		System.out.println("删除成功"+ref);
		//session.commit();//数据库提交删除
		List<Student> l=dao.select();
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
	}
	
	//@Test
	public void testInsert() throws IOException{
		Student s=new Student(4,"jyt","male",new Date(2));
		dao.insert(s);
		
	}
	//@Test
	public void testUpdate() throws IOException{
		Student s=new Student();
		s.setId(1);
		s.setName("jyt");
		s.setSex("男");
		s.setBirth(new Date(1));
		dao.update(s);
		
	}
	
	//@Test
	public void testInsertMajor() throws IOException{
		Student s=new Student();
		s.setName("dalianmao");
		s.setSex("女");
		dao.insertMajor(s);
		System.out.println(s);
	}
	@Test
	@Ignore
	public void testFindByName(){
		
		Student s=new Student();
		s.setName("ff");
		s.setSex("男");
		List<Student> l=dao.findByName(s);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	
	//@Test
	public void testFind(){
		
		Student s=new Student();
		s.setName("ff");
		s.setSex("男");
		s.setBirth(Date.valueOf("2019-10-08"));
		List<Student> l=dao.find(s);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	
	//@Test
	public void testUpdateOne() throws IOException{
		Student s=new Student();
		s.setId(1);
		s.setName("sd");	
		dao.updateOne(s);
	}
	
	//@Test
	public void testFindByIds(){
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(2);
		ids.add(4);

		List<Student> l=dao.findByIds(ids);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	//@Test
	public void testFindInIds(){
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		List<Student> l=dao.findInIds(ids);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	
	//@Test
	public void testFindBind(){
		Student s=new Student();
		s.setName("ff");
		s.setSex("男");
		//s.setBirth(Date.valueOf("2019-10-08"));
		List<Student> l=dao.findBind(s);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
	
	@Test
	public void testFindChoose(){
		Student s=new Student();
		s.setName("ff");
		s.setSex("男");
		//s.setBirth(Date.valueOf("2019-10-08"));
		List<Student> l=dao.findChoose(s);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
		
	}
}
