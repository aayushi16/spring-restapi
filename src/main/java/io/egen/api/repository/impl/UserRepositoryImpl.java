package io.egen.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.User;
import io.egen.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(!users.isEmpty())
		{
			return users.get(0);
		}else{
		return null;
	}
	}
	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
		
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return em.merge(user);
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
	}

}
