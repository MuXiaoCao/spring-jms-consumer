package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import util.DBUtil;
import vo.Student;
import dao.StuDao;
@Repository("sd")
public class StuDaoImpl implements StuDao {
	@PersistenceContext(name="un")
	private EntityManager em;
	@Override
	public int addStu(Student s) {

		
		em.persist(s);
		
		
		return s.getId();
	}

	@Override
	public Student findStu(String xh, String psd) {
		System.out.println("=========" + xh + "========");
		String jpql="select s from Student s where s.xh=:xh and s.psd=:psd";
		List<Student> ls=em.createQuery(jpql)
				.setParameter("xh", xh)
				.setParameter("psd", psd)
				.getResultList();
		System.out.println("==========================" );
		if(ls.isEmpty()) return null;
		else return ls.get(0);
		
	}

	@Override
	public List<Student> findStus() {
		String jpql="select s from Student s";
		List<Student> ls=em.createQuery(jpql).getResultList();
		System.out.println("==========================" );
		if(ls.isEmpty()) return null;
		else return ls;
	}

}
