package com.springbook.biz.user.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	public UserVO getUser(UserVO vo) {
		
		String jpql = "SELECT u FROM USERS u WHERE u.ID = :id AND u.PASSWORD = :password";
		TypedQuery<UserVO> query = em.createQuery(jpql, UserVO.class);
		query.setParameter("id", vo.getId());
		query.setParameter("password", vo.getPassword());
		
		return query.getSingleResult();
//		return (UserVO) em.find(UserVO.class, query);
	}
}
