package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Student;

public class StudentDao {
	
	private Connection conn;

	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public StudentDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean createStudent(Student s) {
		boolean f = false;

		try {
			String sql = "insert into student_details(name,email,age) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setInt(3, s.getAge());


			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		Student s = null;
		try {

			String sql = "select * from student_details order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAge(rs.getInt(4));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStudent(Student s) {
		boolean f = false;

		try {
			String sql = "update student_details set name=?,email=?, age=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setInt(3, s.getAge());
			ps.setInt(4, s.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteStudent(int id) {
		boolean f = false;
		try {
			String sql = "delete from student_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public Student getStudentById(int id) {

		Student s = null;
		try {

			String sql = "select * from student_details where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAge(rs.getInt(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
