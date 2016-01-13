package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import util.DBUtil;
import vo.Student;
import dao.StuDao;
@Repository("sd")
public class StuDaoImpl implements StuDao {
	@Autowired(required=true)
	private DataSource ds;
	@Override
	public int addStu(Student s) {
		int rs=0;
		String sql="insert into stu (uname,sex,xh,psd,groupid) values(?,?,?,?,?)";
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=ds.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, s.getUname());
			pst.setBoolean(2, s.isSex());
			pst.setString(3, s.getXh());
			pst.setString(4, s.getPsd());
			pst.setInt(5, s.getGroupid());
			rs=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, null);
		}
		
		
		return rs;
	}

	@Override
	public Student findStu(String xh, String psd) {
		Student s=null;
		String sql="select * from stu where xh=? and psd=?";
		Connection con=DBUtil.connect();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, xh);
			pst.setString(2, psd);
			rs=pst.executeQuery();
			if(rs.next()){
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setUname(rs.getString("uname"));
				s.setSex(rs.getBoolean("sex"));
				s.setXh(rs.getString("xh"));
				s.setGroupid(rs.getInt("groupid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		
		
		
		
		return s;
	}

}
