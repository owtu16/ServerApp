package com.project.servers.app.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.servers.app.entity.User;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public String authenticateUser(String username, String password) {
		String sql = "SELECT u FROM User u WHERE u.username = '"+username+"' and u.password = '"+password+"'";
		Query q = entityManager.createQuery(sql);
		
		List<User> list = q.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0).getUsername();
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		String sql = "FROM User u WHERE u.username = '"+username+"'";
		Query q = entityManager.createQuery(sql);
		List<User> list = q.getResultList();
		user = list.get(0);
		return user;
	}

	

}
